package com.mindnode.immipal.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mindnode.immipal.pojo.Ad;
import com.mindnode.immipal.pojo.Category;
import com.mindnode.immipal.pojo.News;
import com.mindnode.immipal.service.AdService;
import com.mindnode.immipal.service.CategoryService;
import com.mindnode.immipal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
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

        categoryList = categoryService.listAllOrderByLevel();

        data.put("categoryList", categoryList);

        return JSON.toJSONString(data);
    }

    /**
     * 首页即为"推荐"页面
     * 推荐分类展示页
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Integer pageNum,
                        Integer adLevel) {
        if (pageNum == null) {
            PageHelper.startPage(1, PAGE_SIZE);
        } else {
            PageHelper.startPage(pageNum, PAGE_SIZE);
        }

        Map<String, Object> data = new HashMap<>(4);
        Ad ad = null;
        List<News> newsList = null;
        try {
            ad = adService.getFirstByAdLevel(adLevel);
            newsList = newsService.listByRecommend();
        } catch (Exception e) {
            data.put("message", e.getMessage());
        }

        data.put("ad", ad);
        data.put("newsList", newsList);

        // if (newsList != null) {
        //     PageInfo<News> pageInfo = new PageInfo<>(newsList);
        //     data.put("pageInfo", pageInfo);
        // }
        return JSON.toJSONString(data);
    }

    /**
     * 最新分类展示页
     */
    @RequestMapping(value = "/newest", method = RequestMethod.GET)
    public String newest(Integer pageNum,
                         Integer adLevel) {
        if (pageNum == null) {
            PageHelper.startPage(1, PAGE_SIZE);
        } else {
            PageHelper.startPage(pageNum, PAGE_SIZE);
        }

        Map<String, Object> data = new HashMap<>(4);
        Ad ad = null;
        List<News> newsList = null;
        try {
            ad = adService.getFirstByAdLevel(adLevel);
            newsList = newsService.listAllOrderByCreateTime();
        } catch (Exception e) {
            data.put("message", e.getMessage());
        }

        data.put("ad", ad);
        data.put("newsList", newsList);

        // if (newsList != null) {
        //     PageInfo<News> pageInfo = new PageInfo<>(newsList);
        //     data.put("pageInfo", pageInfo);
        // }
        return JSON.toJSONString(data);
    }

    /**
     * 固定分类展示页
     */
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String fixedCategory(Integer pageNum,
                                Integer categoryId,
                                Integer adLevel) {
        if (pageNum == null) {
            PageHelper.startPage(1, PAGE_SIZE);
        } else {
            PageHelper.startPage(pageNum, PAGE_SIZE);
        }

        Map<String, Object> data = new HashMap<>(4);
        Ad ad = null;
        List<News> newsList = null;
        try {
            ad = adService.getFirstByAdLevel(adLevel);
            newsList = newsService.listByCategoryId(categoryId);
        } catch (Exception e) {
            data.put("message", e.getMessage());
        }

        data.put("ad", ad);
        data.put("newsList", newsList);

        // if (newsList != null) {
        //     PageInfo<News> pageInfo = new PageInfo<>(newsList);
        //     data.put("pageInfo", pageInfo);
        // }
        return JSON.toJSONString(data);
    }



}
