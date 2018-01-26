package com.mindnode.immipal.controller;

import com.mindnode.immipal.pojo.Category;
import com.mindnode.immipal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 控制台的跳转
 *
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * 显示全部分类列表
     * 栏目分类管理页面
     */
    @RequestMapping(value = "/admin_category_list", method = RequestMethod.GET)
    public String listCategory(Model model) {
        List<Category> categoryList = categoryService.listAll();
        model.addAttribute("categoryList", categoryList);
        return "admin/listCategory";
    }

    /**
     * 显示全部新闻列表
     * 新闻列表管理页面
     */
    @RequestMapping(value = "/admin_news_list", method = RequestMethod.GET)
    public String listNews(Model model) {
        List<Category> categoryList = categoryService.listAll();
        model.addAttribute("categoryList", categoryList);
        return "admin/listNews";
    }

    /**
     * 显示全部广告列表
     * 广告管理页面
     */
    @RequestMapping(value = "/admin_ad_list", method = RequestMethod.GET)
    public String listAd(Model model) {
        List<Category> categoryList = categoryService.listAll();
        model.addAttribute("categoryList", categoryList);
        return "admin/listAd";
    }
}
