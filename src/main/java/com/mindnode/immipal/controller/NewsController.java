package com.mindnode.immipal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mindnode.immipal.exception.upload.FileUploadException;
import com.mindnode.immipal.pojo.Category;
import com.mindnode.immipal.pojo.News;
import com.mindnode.immipal.pojo.Pic;
import com.mindnode.immipal.pojo.Video;
import com.mindnode.immipal.service.CategoryService;
import com.mindnode.immipal.service.NewsService;
import com.mindnode.immipal.service.PicService;
import com.mindnode.immipal.service.VideoService;
import com.mindnode.immipal.util.upload.FileUpLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 后台-新闻管理
 *
 * @author SQM
 * @version 1.0
 * @date 2018/1/27
 */
@Controller
@RequestMapping("/admin/news")
public class NewsController {
    private final int PAGE_SIZE = 10;

    private final String REDIRECT_NEWS_LIST = "redirect:/admin/news/admin_news_list";
    private final String REDIRECT_RECOMMEND_NEWS_LIST = "redirect:/admin/news/admin_news_list_recommend";
    private final String REDIRECT_NEWS_LIST_BY_CATEGORY_ID = "redirect:/admin/news/admin_news_list_by_category_id?categoryId=";
    private final String REDIRECT_NEWS_ADD = "redirect:/admin/news/admin_news_add";


    @Autowired
    NewsService newsService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    PicService picService;
    @Autowired
    VideoService videoService;
    

    /**
     * 显示全部新闻列表
     * 新闻列表管理页面
     */
    @RequestMapping(value = "/admin_news_list", method = RequestMethod.GET)
    public String listNews(Integer pageNum, Model model) {
        if (pageNum == null) {
            PageHelper.startPage(1, PAGE_SIZE);
        } else {
            PageHelper.startPage(pageNum, PAGE_SIZE);
        }

        List<News> newsList = null;
        List<Category> categoryList = null;

        try {
            newsList = newsService.listAllOrderByCreateTime();
            categoryList = categoryService.listAllOrderByLevel();
            model.addAttribute("imgUrlMap", getShowImgUrlsMap(newsList));
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }


        model.addAttribute("categoryList", categoryList);
        model.addAttribute("newsList", newsList);

        PageInfo<News> pageInfo = new PageInfo<>(newsList);
        model.addAttribute("pageInfo", pageInfo);

        return "admin/listNews";
    }

    /**
     * 显示推荐新闻列表
     */
    @RequestMapping(value = "/admin_news_list_recommend", method = RequestMethod.GET)
    public String listRecommendedNews(Integer pageNum, Model model) {
        if (pageNum == null) {
            PageHelper.startPage(1, PAGE_SIZE);
        } else {
            PageHelper.startPage(pageNum, PAGE_SIZE);
        }
        List<News> newsList = null;
        List<Category> categoryList = null;
        try {
            newsList = newsService.listByRecommend();
            categoryList = categoryService.listAllOrderByLevel();
    
            model.addAttribute("imgUrlMap", getShowImgUrlsMap(newsList));
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("newsList", newsList);

        PageInfo<News> pageInfo = new PageInfo<>(newsList);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/listNews";
    }

    /**
     * 显示分类对应的新闻列表
     */
    @RequestMapping(value = "/admin_news_list_by_category_id", method = RequestMethod.GET)
    public String listNewsByCategoryId(Integer categoryId, Integer pageNum, Model model) {
        if (pageNum == null) {
            PageHelper.startPage(1, PAGE_SIZE);
        } else {
            PageHelper.startPage(pageNum, PAGE_SIZE);
        }
        List<News> newsList = null;
        List<Category> categoryList = null;
        try {
            newsList = newsService.listByCategoryId(categoryId);
            categoryList = categoryService.listAllOrderByLevel();
            
            model.addAttribute("imgUrlMap", getShowImgUrlsMap(newsList));
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("newsList", newsList);

        PageInfo<News> pageInfo = new PageInfo<>(newsList);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/listNewsByCategoryId";
    }

    /**
     * 新增新闻页面，要获取全部栏目列表
     */
    @RequestMapping(value = "/admin_news_add_page", method = RequestMethod.GET)
    public String addNewsPage(Model model) {

        List<Category> categoryList = null;
        try {
            categoryList = categoryService.listAll();
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("categoryList", categoryList);

        return "admin/add/addNews";
    }

    /**
     * 修改新闻页面，除了获取新闻id对应的新闻外，还要获取全部栏目列表
     */
    @RequestMapping(value = "/admin_news_edit_page", method = RequestMethod.GET)
    public String editNewsPage(Integer newsId, Model model) {
        News news = null;
        List<Category> categoryList = null;
        try {
            news = newsService.getByNewsId(newsId);
            categoryList = categoryService.listAll();
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("news", news);

        return "admin/edit/editNews";
    }
    
    /**
     * 查看新闻详情页面
     */
    @RequestMapping(value = "/admin_news_detail", method = RequestMethod.GET)
    public String newsDetail(Integer newsId, Model model) {
        News news = newsService.getByNewsId(newsId);
        model.addAttribute("news", news);
        return "admin/show/showNewsDetail";
    }
    
    /**
     * 新增新闻通过获取的categoryId设置categoryTitle
     * 新建一个新闻，要获取当前时间毫秒值
     * 新闻中包含了最多三张图片的上传或一个视频的上传
     * 是否有视频是通过单选选择，值为yes，no
     */
    @RequestMapping(value = "/admin_news_add", method = RequestMethod.POST)
    public String addNews(HttpSession session,
                          News news,
                          MultipartFile[] file,
                          String hasVideoOption,
                          Model model) {
        
        try {
            //新闻所属栏目分类标题未分配，此时通过表单里的categoryId来分配其categoryTitle
            Category category = categoryService.get(news.getCategoryId());
            String categoryTitle = category.getCategoryTitle();
            news.setCategoryTitle(categoryTitle);
            
            //设定其创建时间：包括时间信息及毫秒值
            final long nowLong = System.currentTimeMillis();
            final Date nowDate = new Date(nowLong);
            //设定置顶与推荐的初始值
            news.setNewsCreateTime(nowLong);
            news.setNewsDate(nowDate);
            news.setNewsTop(false);
            news.setRecommend(false);
            news.setNewsRecommendTop(false);
            
            StringBuilder imgUrl = new StringBuilder();
            // 判断是否有上传文件
            if (file.length == 0) {
                model.addAttribute("message", "请上传展示图片");
                return REDIRECT_NEWS_LIST;
            } else {
                final String yes = "yes";
                final String no = "no";
                //判断是否有视频,默认为no
                switch (hasVideoOption) {
                    
                    case no:
                        
                        //设置hasVideo为false
                        news.setHasVideo(false);
                        
                        //上传图片
                        for (MultipartFile multipartFile : file) {
                            //上传图片，将图片地址传入数据库，并返回服务器地址
                            imgUrl = imgUrl.append(uploadPicAndSetPicDB(session, multipartFile)).append(",");
                        }
                        break;
                    
                    case yes:
                        
                        // 设置hasVideo为true
                        news.setHasVideo(true);
                        //上传了一个视频，一张图片
                        //判断是否为视频
                        for (MultipartFile multipartFile : file) {
                            //如果是视频，上传视频
                            String originalName = multipartFile.getOriginalFilename();
                            if (FileUpLoad.isVideo(originalName)) {
                                String videoUrl = uploadVideoAndSetVideoDB(session, multipartFile);
                                //设置news的videoUrl
                                news.setVideoUrl(videoUrl);
                            }
                            //如果是图片，上传图片
                            else if (FileUpLoad.isPic(originalName)) {
                                //上传图片，将图片地址传入数据库，并返回服务器地址
                                imgUrl = imgUrl.append(uploadPicAndSetPicDB(session, multipartFile)).append(",");
                            }
                            //如果是其他文件，返回原页面
                            else {
                                return REDIRECT_NEWS_ADD;
                            }
                        }
                        break;
                    
                    default:
                        
                        return REDIRECT_NEWS_LIST;
                }
                //imgUrl为 "url,url,url," 的形式
                news.setShowImgUrls(imgUrl.toString());
                //最终都要新增入数据库
                newsService.add(news);
            }
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return REDIRECT_NEWS_LIST;
    }

    /**
     * 修改一个新闻
     */
    @RequestMapping(value = "/admin_news_edit", method = RequestMethod.POST)
    public String editNews(HttpSession session,
                           News news,
                           MultipartFile[] file,
                           String hasVideoOption,
                           String reUploadVideo,
                           String reUploadPic,
                           Model model) {
        try {
            News originalNews = newsService.getByNewsId(news.getNewsId());

            //新闻所属栏目分类标题未分配，此时通过表单里的categoryId来分配其categoryTitle
            Category category = categoryService.get(news.getCategoryId());
            String categoryTitle = category.getCategoryTitle();
            news.setCategoryTitle(categoryTitle);

            //设置新闻未被分配的属性
            news.setNewsDate(originalNews.getNewsDate());
            news.setNewsCreateTime(originalNews.getNewsCreateTime());
            news.setNewsTop(originalNews.getNewsTop());
            news.setRecommend(originalNews.getRecommend());
            news.setNewsRecommendTop(originalNews.getNewsRecommendTop());

            StringBuilder imgUrl = new StringBuilder();

            final String yes = "yes";
            final String no = "no";

            //是否重新上传视频
            switch (reUploadVideo) {
                // 若重新上传视频或设置hasVideo为false
                case yes:
                    //设置是否有视频
                    switch (hasVideoOption) {
                        //重新上传视频
                        case yes:
                            // 设置hasVideo为true
                            news.setHasVideo(true);
                            //上传了一个视频，一张图片
                            //判断是否为视频
                            for (MultipartFile multipartFile : file) {
                                //如果是视频，上传视频
                                if (!multipartFile.isEmpty()) {
                                    String originalName = multipartFile.getOriginalFilename();
                                    if (FileUpLoad.isVideo(originalName)) {
                                        String videoUrl = uploadVideoAndSetVideoDB(session, multipartFile);
                                        //设置news的videoUrl
                                        news.setVideoUrl(videoUrl);
                                    }
                                    //如果是其他文件，不管，往下执行
                                }
                            }
                            break;
                        //设置没有视频
                        case no:
                            //设置hasVideo为false
                            news.setHasVideo(false);
                            //设置videoUrl为原来的值
                            news.setVideoUrl(originalNews.getVideoUrl());
                            break;
                        default:
                            break;
                    }
                    break;
                //若不重新上传视频
                case no:
                    // hasVideo设置为原来的值
                    news.setHasVideo(originalNews.getHasVideo());
                    //videoUrl设置为原来的值
                    news.setVideoUrl(originalNews.getVideoUrl());
                    break;
                default:
                    break;
            }
            //是否重新上传图片
            switch (reUploadPic) {
                // 重新上传图片
                case yes:
                    //判断是否有文件
                    //判断是否为图片
                    for (MultipartFile multipartFile : file) {
                        if (!multipartFile.isEmpty()) {
                            String originalName = multipartFile.getOriginalFilename();
                            //如果是图片，上传图片
                            if (FileUpLoad.isPic(originalName)) {
                                //上传图片，将图片地址传入数据库，并返回服务器地址
                                imgUrl = imgUrl.append(uploadPicAndSetPicDB(session, multipartFile)).append(",");
                            }
                            //如果是其他文件，不管，往下执行
                        }
                    }
                    // 循环完设置news的showImgUrls为imgUrl
                    news.setShowImgUrls(imgUrl.toString());
                    break;
                //不重新上传图片
                case no:
                    //设置showImgUrls为原来的值
                    news.setShowImgUrls(originalNews.getShowImgUrls());
                    break;
                default:
                    break;
            }
            //最终更新news
            newsService.update(news);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return REDIRECT_NEWS_LIST;
    }

    /**
     * 删除新闻
     */
    @RequestMapping(value = "/admin_news_delete", method = RequestMethod.GET)
    public String deleteNews(Integer newsId) {
        newsService.delete(newsId);
        return REDIRECT_NEWS_LIST;
    }


    /**
     * 设为推荐
     */
    @RequestMapping(value = "/admin_news_recommend", method = RequestMethod.GET)
    public String recommendNews(Integer newsId) {
        News news = newsService.getByNewsId(newsId);
        news.setRecommend(true);
        newsService.update(news);
        return REDIRECT_NEWS_LIST;
    }

    /**
     * 取消推荐
     */
    @RequestMapping(value = "/admin_news_recommend_cancel", method = RequestMethod.GET)
    public String cancelRecommendNews(Integer newsId) {
        News news = newsService.getByNewsId(newsId);
        news.setRecommend(false);
        //没有了推荐自然也不会在推荐中置顶
        news.setNewsRecommendTop(false);
        newsService.update(news);
        return REDIRECT_NEWS_LIST;
    }

    /**
     * 设为置顶,取消同分类的已置顶的news
     */
    @RequestMapping(value = "/admin_news_top", method = RequestMethod.GET)
    public String topNews(Integer newsId,Model model) {
        try {
            News news = newsService.getByNewsId(newsId);
            List<News> topNewsList = newsService.listByNewsTopTrueAndCategoryId(news.getCategoryId());
            if (topNewsList != null) {
                for (News topNews : topNewsList) {
                    topNews.setNewsTop(false);
                    newsService.update(topNews);
                }
            }
            news.setNewsTop(true);
            newsService.update(news);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return REDIRECT_NEWS_LIST;
    }

    /**取消置顶*/
    @RequestMapping(value = "/admin_news_top_cancel",method = RequestMethod.GET)
    public String cancelTopNews(Integer newsId) {

        News news = newsService.getByNewsId(newsId);
        news.setNewsTop(false);
        newsService.update(news);
        return REDIRECT_NEWS_LIST;
    }

    /**
     * 设为推荐置顶
     */
    @RequestMapping(value = "/admin_news_recommend_top", method = RequestMethod.GET)
    public String topRecommendNews(Integer newsId, Model model) {
        try {
            News news = newsService.getByNewsId(newsId);
            List<News> recommendTopNewsList = newsService.listByNewsRecommendTopTrue();
            if (recommendTopNewsList != null) {
                for (News recommendTopNews : recommendTopNewsList) {
                    recommendTopNews.setNewsRecommendTop(false);
                    newsService.update(recommendTopNews);
                }
            }
            //推荐置顶前推荐肯定是true
            news.setRecommend(true);
            news.setNewsRecommendTop(true);
            newsService.update(news);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return REDIRECT_NEWS_LIST;
    }

    /**
     * 取消推荐置顶
     */
    @RequestMapping(value = "/admin_news_recommend_top_cancel", method = RequestMethod.GET)
    public String cancelTopRecommendNews(Integer newsId) {
        News news = newsService.getByNewsId(newsId);
        news.setNewsRecommendTop(false);
        newsService.update(news);
        return REDIRECT_NEWS_LIST;
    }
    
    /**
     * 新闻图片的映射，key为newsId，value为showImgUrl转换成的Array
     */
    private Map<Integer, String[]> getShowImgUrlsMap(List<News> newsList) {
        Map<Integer, String[]> imgUrlMap = new HashMap<>(16);
        //获取每个news的showImgUrls字符串，通过split分割后获取到每张展示图片，存入imgUrlMap中
        for (News news : newsList) {
            String imgUrls = news.getShowImgUrls();
            String[] imgUrlArray = imgUrls.split(",");
            imgUrlMap.put(news.getNewsId(), imgUrlArray);
        }
        return imgUrlMap;
    }

    /**上传图片，并将图片地址存入数据库，并返回图片地址*/
    private String uploadPicAndSetPicDB(HttpSession session, MultipartFile multipartFile) throws IOException, FileUploadException {

        String imgUrl = FileUpLoad.uploadPic(session, multipartFile);
        //新增Pic
        Pic pic = new Pic();
        pic.setPicUrl(imgUrl);
        picService.add(pic);
        return imgUrl;
    }

    /**上传视频，将视频地址存入数据库，并返回视频地址*/
    private String uploadVideoAndSetVideoDB(HttpSession session,MultipartFile multipartFile) throws IOException, FileUploadException{
        String videoUrl = FileUpLoad.uploadVideo(session, multipartFile);
        //新增Video
        Video video = new Video();
        video.setVideoUrl(videoUrl);
        videoService.add(video);
        return videoUrl;
    }
}

