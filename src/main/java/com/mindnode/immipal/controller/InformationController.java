package com.mindnode.immipal.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mindnode.immipal.exception.list.NullListException;
import com.mindnode.immipal.pojo.Ad;
import com.mindnode.immipal.pojo.Category;
import com.mindnode.immipal.pojo.News;
import com.mindnode.immipal.service.AdService;
import com.mindnode.immipal.service.CategoryService;
import com.mindnode.immipal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页中：分类导航栏与其他元素分开请求
 * 请求一：分页对象page，新闻列表newsList，广告对象ad
 * 请求二：分类列表categoryList
 *
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
@Controller
@RequestMapping("")
public class InformationController {
    private final int PAGE_SIZE = 10;
    @Autowired
    NewsService newsService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AdService adService;

    /**
     * 资讯分类导航条
     */
    @RequestMapping(value = "/navigator", method = RequestMethod.GET)
    public String navigator() {

        Map<String, Object> data = new HashMap<>(2);

        List<Category> categoryList = null;
        try {
            categoryList = categoryService.listAllOrderByLevel();
        } catch (NullListException e) {
            data.put("message", e.getMessage());
        }

        data.put("categoryList", categoryList);

        return JSON.toJSONString(data);
    }

    /**首页即为"推荐"页面*/
    /**
     * 推荐分类展示页
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Page page,
                        @RequestParam("adLevel")Integer adLevel) {
        Map<String, Object> data = new HashMap<>(4);

        Ad ad = null;
        try {
            ad = adService.getFirstByAdLevel(adLevel);
        } catch (Exception e) {
            data.put("message", e.getMessage());
        }

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<News> newsList = null;
        try {
            newsList = newsService.listByRecommend();
        } catch (NullListException e) {
            data.put("message", e.getMessage());
        }

        data.put("ad", ad);
        data.put("newsList", newsList);
        data.put("page", page);

        return JSON.toJSONString(data);
    }

    /**
     * 最新分类展示页
     */
    @RequestMapping(value = "/newest", method = RequestMethod.GET)
    public String newest(Page page,
                         @RequestParam("adLevel")Integer adLevel) {
        Map<String, Object> data = new HashMap<>(4);

        Ad ad = null;
        try {
            ad = adService.getFirstByAdLevel(adLevel);
        } catch (Exception e) {
            data.put("message", e.getMessage());
        }

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<News> newsList = null;
        try {
            newsList = newsService.listAllOrderByCreateTime();
        } catch (NullListException e) {
            data.put("message", e.getMessage());
        }

        data.put("ad", ad);
        data.put("newsList", newsList);
        data.put("page", page);

        return JSON.toJSONString(data);
    }

    /**
     * 固定分类展示页
     */
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String fixedCategory(Page page,
                                @RequestParam("categoryId") Integer categoryId,
                                @RequestParam("adLevel")Integer adLevel) {

        Map<String, Object> data = new HashMap<>(4);

        Ad ad = null;
        try {
            ad = adService.getFirstByAdLevel(adLevel);
        } catch (Exception e) {
            data.put("message", e.getMessage());
        }

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<News> newsList = null;
        try {
            newsList = newsService.listByCategoryId(categoryId);
        } catch (NullListException e) {
            data.put("message", e.getMessage());
        }

        int total = (int) new PageInfo<>(newsList).getTotal();
        page.setTotal(total);

        data.put("ad", ad);
        data.put("newsList", newsList);
        data.put("page", page);

        return JSON.toJSONString(data);
    }



}
