package com.mindnode.immipal.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mindnode.immipal.exception.upload.FileUploadException;
import com.mindnode.immipal.pojo.Category;
import com.mindnode.immipal.pojo.News;
import com.mindnode.immipal.service.CategoryService;
import com.mindnode.immipal.service.NewsService;
import com.mindnode.immipal.util.upload.FileUpLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private final int PAGE_SIZE = 5;

    private final String REDIRECT_NEWS_LIST = "redirect:/admin/admin_news_list";
    private final String REDIRECT_RECOMMEND_NEWS_LIST = "redirect:/admin/admin_news_list_recommend";
    private final String REDIRECT_NEWS_LIST_BY_CATEGORY_ID = "redirect:/admin/admin_news_list_by_category_id";


    @Autowired
    NewsService newsService;
    @Autowired
    CategoryService categoryService;

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
        model.addAttribute("newsList", newsList);
        model.addAttribute("categoryList", categoryList);
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
        model.addAttribute("newsList", newsList);
        model.addAttribute("categoryList", categoryList);
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
     * 新建一个新闻，要获取当前时间毫秒值
     * 新闻中包含了最多三张图片的上传或一个视频的上传
     * 是否有视频是通过单选选择，值为yes，no
     */
    @RequestMapping(value = "/admin_news_add", method = RequestMethod.POST)
    public String addNews(HttpSession session,
                          News news,
                          @RequestParam("pic") MultipartFile[] pics,
                          @RequestParam("video") MultipartFile video,
                          @RequestParam("hasVideoOption") String hasVideoOption,
                          Model model) {
        final String redirectNewsAddPage = "redirect:/admin/admin_news_add_page";
        if (news == null) {
            return redirectNewsAddPage;
        } else {
            try {
                news.setNewsCreateTime(System.currentTimeMillis());
                final String yes = "yes";
                final String no = "no";
                if (hasVideoOption == null) {
                    model.addAttribute("message", "请选择此条新闻是否包含视频");
                    return redirectNewsAddPage;
                }
                //hasVideoOption=yes
                if (hasVideoOption.equals(yes)) {
                    //如果没有视频文件则提醒上传视频
                    if (video.isEmpty()) {
                        model.addAttribute("message", "没有视频文件");
                        return redirectNewsAddPage;
                    }
                    //有视频文件要上传则设置news的hasVideo为true，上传视频，不管展示图片
                    else {
                        newsUploadVideo(session, news, video);
                    }
                }
                //hasVideoOption=no
                if (hasVideoOption.equals(no)) {
                    //如果没有图片文件则提醒上传图片
                    if (pics.length == 0) {
                        model.addAttribute("message", "没有图片");
                        return redirectNewsAddPage;
                    }
                    //有图片文件则设置news的hasVideo为false，上传图片
                    else {
                        newsUploadPic(session, news, pics);
                    }
                }
                newsService.add(news);
            } catch (FileUploadException e) {
                model.addAttribute("message", e.getMessage());
            } catch (IOException e) {
                model.addAttribute("message", "传输文件失败");
            }
        }
        return REDIRECT_NEWS_LIST;
    }

    /**
     * 修改一个新闻
     */
    @RequestMapping(value = "/admin_news_edit", method = RequestMethod.POST)
    public String editNews(HttpSession session,
                           News news,
                           @RequestParam("pic") MultipartFile[] pics,
                           @RequestParam("video") MultipartFile video,
                           @RequestParam("hasVideoOption") String hasVideoOption,
                           Model model) {
        final String redirectNewsEditPage = "redirect:/admin/admin_news_edit_page";
        if (news == null) {
            return REDIRECT_NEWS_LIST;
        } else {
            try {
                final String yes = "yes";
                final String no = "no";
                if (hasVideoOption == null) {
                    model.addAttribute("message", "请选择此条新闻是否包含视频");
                    return redirectNewsEditPage + "?newsID=" + news.getNewsId();
                }
                //hasVideoOption=yes，
                if (hasVideoOption.equals(yes)) {
                    //如果没有视频文件则提醒上传视频
                    if (video.isEmpty()) {
                        model.addAttribute("message", "没有视频文件");
                        return redirectNewsEditPage + "?newsID=" + news.getNewsId();
                    }
                    //如果有视频文件则替换原文件，设置news的hasVideo为true，上传视频，不管展示图片
                    else {
                        newsUploadVideo(session, news, video);
                    }
                }
                //hasVideoOption=false
                if (hasVideoOption.equals(no)) {
                    //如果没有图片文件则提醒上传图片
                    if (pics.length == 0) {
                        model.addAttribute("message", "没有图片");
                        return redirectNewsEditPage + "?newsID=" + news.getNewsId();
                    }
                    //如果有图片文件则替换源文件，设置news的hasVideo为false，上传图片，不管视频
                    else {
                        newsUploadPic(session, news, pics);
                    }
                }
                newsService.update(news);
            } catch (FileUploadException e) {
                model.addAttribute("message", e.getMessage());
            } catch (IOException e) {
                model.addAttribute("message", "传输文件失败");
            }
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

    private void newsUploadVideo(HttpSession session,News news,MultipartFile video) throws FileUploadException,IOException {
        news.setHasVideo(true);
        String videoPath = FileUpLoad.uploadVideo(session, video);
        news.setShowImgUrls(videoPath);

        System.out.println("视频上传的访问地址：" + videoPath);
    }

    private void newsUploadPic(HttpSession session,News news, MultipartFile[] pics) throws FileUploadException,IOException {
        news.setHasVideo(false);
        List<String> picPaths = new ArrayList<>();
        for (MultipartFile pic : pics) {
            String picPath = FileUpLoad.uploadPic(session, pic);
            picPaths.add(picPath);
        }
        String json = JSON.toJSONString(picPaths);
        news.setShowImgUrls(json);

        System.out.println("图片上传的地址：" + json);
    }
}
