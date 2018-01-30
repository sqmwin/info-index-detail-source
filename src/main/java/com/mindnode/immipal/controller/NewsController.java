package com.mindnode.immipal.controller;

import com.alibaba.fastjson.JSON;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 后台-新闻管理
 *
 * @author SQM
 * @version 1.0
 * @date 2018/1/27
 */
@Controller
@RequestMapping("/admin")
public class NewsController {
    private final int PAGE_SIZE = 10;

    private final String REDIRECT_NEWS_LIST = "redirect:/admin/admin_news_list";
    private final String REDIRECT_RECOMMEND_NEWS_LIST = "redirect:/admin/admin_news_list_recommend";
    private final String REDIRECT_NEWS_LIST_BY_CATEGORY_ID = "redirect:/admin/admin_news_list_by_category_id";


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
            categoryList = categoryService.listAll();
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
            categoryList = categoryService.listAll();
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
            categoryList = categoryService.listAll();
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

            //设定其创建时间：包括时间信息及毫秒值;设定置顶与推荐的初始值
            final long nowLong = System.currentTimeMillis();
            final Date nowDate = new Date(nowLong);
            news.setNewsCreateTime(nowLong);
            news.setNewsDate(nowDate);
            news.setNewsTop(false);
            news.setRecommend(false);
            news.setNewsRecommendTop(false);
            // 判断是否有上传文件
            if (file.length == 0) {
                model.addAttribute("message", "请上传展示图片");
                return "redirect:/admin/admin_news_list";
            } else {
                final String yes = "yes";
                final String no = "no";
                List<String> showImgUrlsList = new ArrayList<>();
                //判断是否有视频,默认为no
                if (hasVideoOption.equals(no)) {
                    //设置hasVideo为false
                    news.setHasVideo(false);

                    //上传图片
                    for (MultipartFile multipartFile : file) {
                        //上传图片，将图片地址传入数据库，并返回服务器地址
                        String imgUrl = uploadPicAndSetPicDB(session, multipartFile);
                        //设置showImgUrls
                        showImgUrlsList.add(imgUrl);
                    }
                }
                //如果有视频
                if (hasVideoOption.equals(yes)) {
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
                        else if(FileUpLoad.isPic(originalName)) {
                            //上传图片，将图片地址传入数据库，并返回服务器地址
                            String imgUrl = uploadPicAndSetPicDB(session, multipartFile);
                            //设置news的showImgUrls
                            showImgUrlsList.add(imgUrl);
                        }
                        //如果是其他文件，返回原页面
                        else {
                            return "redirect:/admin/admin_news_add";
                        }
                    }
                }
                //图片上传完后设置news的showImgUrls字段
                news.setShowImgUrls(JSON.toJSONString(showImgUrlsList));
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
                           String content,
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
            news.setNewsContent(content);
            news.setNewsDate(originalNews.getNewsDate());
            news.setNewsCreateTime(originalNews.getNewsCreateTime());
            news.setNewsTop(originalNews.getNewsTop());
            news.setRecommend(originalNews.getRecommend());
            news.setNewsRecommendTop(originalNews.getNewsRecommendTop());

            final String yes = "yes";
            final String no = "no";
            List<String> showImgUrlsList = new ArrayList<>();
            //若重新上传视频或删除原视频
            if (reUploadVideo.equals(yes)) {
                //如果hasVideo为yes
                if (hasVideoOption.equals(yes)) {
                    // 设置hasVideo为true
                    news.setHasVideo(true);
                    // 判断是否重新上传展示图片
                    if (reUploadPic.equals(yes)) {
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
                                String imgUrl = uploadPicAndSetPicDB(session, multipartFile);
                                //设置news的showImgUrls
                                showImgUrlsList.add(imgUrl);
                                //图片上传完后设置news的showImgUrls字段
                                news.setShowImgUrls(JSON.toJSONString(showImgUrlsList));
                            }
                        }
                    }
                    if (reUploadPic.equals(no)) {
                        for (MultipartFile multipartFile : file) {
                            //如果是视频，上传视频
                            String originalName = multipartFile.getOriginalFilename();
                            if (FileUpLoad.isVideo(originalName)) {
                                String videoUrl = uploadVideoAndSetVideoDB(session, multipartFile);
                                //设置news的videoUrl
                                news.setVideoUrl(videoUrl);
                            }
                        }
                        news.setShowImgCount(originalNews.getShowImgCount());
                        news.setShowImgUrls(originalNews.getShowImgUrls());
                    }
                }
                if (hasVideoOption.equals(no)) {
                    //设置hasVideo为false
                    news.setHasVideo(false);
                    //上传图片
                    if (file.length != 0) {
                        for (MultipartFile multipartFile : file) {
                            if (!multipartFile.isEmpty()) {
                                //上传图片，将图片地址传入数据库，并返回服务器地址
                                String imgUrl = uploadPicAndSetPicDB(session, multipartFile);
                                //设置showImgUrls
                                showImgUrlsList.add(imgUrl);
                                //图片上传完后设置news的showImgUrls字段
                                news.setShowImgUrls(JSON.toJSONString(showImgUrlsList));
                            }
                        }
                    }
                }
            }
            //不更改视频
            else if (reUploadVideo.equals(no)) {
                news.setHasVideo(originalNews.getHasVideo());
                news.setVideoUrl(originalNews.getVideoUrl());
                if (reUploadPic.equals(yes)) {
                    //上传图片
                    if (file.length != 0) {
                        for (MultipartFile multipartFile : file) {
                            if (!multipartFile.isEmpty()) {
                                String originalName = multipartFile.getOriginalFilename();
                                if (FileUpLoad.isPic(originalName)) {
                                    //上传图片，将图片地址传入数据库，并返回服务器地址
                                    String imgUrl = uploadPicAndSetPicDB(session, multipartFile);
                                    //设置showImgUrls
                                    showImgUrlsList.add(imgUrl);
                                    //图片上传完后设置news的showImgUrls字段
                                    news.setShowImgUrls(JSON.toJSONString(showImgUrlsList));
                                }
                            }
                        }
                    }
                }
                //不上传图片
                else if (reUploadPic.equals(no)) {
                    news.setShowImgCount(originalNews.getShowImgCount());
                    news.setShowImgUrls(originalNews.getShowImgUrls());
                }
            }

            //最终都要新增入数据库
            newsService.update(news);
        }catch (Exception e) {
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
    public String recommendNews(Integer newsId,Model model) {
        News news = newsService.getByNewsId(newsId);
        news.setRecommend(true);
        newsService.update(news);
        return REDIRECT_NEWS_LIST;
    }

    /**
     * 取消推荐
     */
    @RequestMapping(value = "/admin_news_recommend_cancel", method = RequestMethod.GET)
    public String cancelRecommendNews(Integer newsId,Model model) {
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
    public String cancelTopNews(Integer newsId,Model model) {

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
    public String cancelTopRecommendNews(Integer newsId, Model model) {
        News news = newsService.getByNewsId(newsId);
        news.setNewsRecommendTop(false);
        newsService.update(news);
        return REDIRECT_NEWS_LIST;
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

