package com.mindnode.immipal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    private final int PAGE_SIZE = 10;
    @Autowired
    CategoryService categoryService;

    /**
     * 显示全部分类列表
     * 栏目分类管理页面
     */
    @RequestMapping(value = "/admin_category_list", method = RequestMethod.GET)
    public String listCategory(Integer pageNum, Model model) {
        //在你需要进行分页的 MyBatis 查询方法前调用 PageHelper.startPage 静态方法即可，
        //紧跟在这个方法后的第一个MyBatis 查询方法会被进行分页。
        if (pageNum==null) {
            PageHelper.startPage(1, PAGE_SIZE);
        } else {
            PageHelper.startPage(pageNum, PAGE_SIZE);
        }
        List<Category> categoryList = categoryService.listAll();

        model.addAttribute("categoryList", categoryList);

        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        model.addAttribute("pageInfo", pageInfo);

        return "admin/listCategory";
    }

    /**
     * 新增栏目
     */
    @RequestMapping(value = "/admin_category_add", method = RequestMethod.POST)
    public String addCategory(Category category,Model model) {
        String nothing = "";
        if (category.getCategoryTitle().equals(nothing)) {
            model.addAttribute("message", "栏目名不能为空");
            return "redirect:/admin/admin_category_list";
        }
        categoryService.add(category);
        return "redirect:/admin/admin_category_list";

    }

    /**
     * 编辑栏目的页面
     */
    @RequestMapping(value = "/admin_category_edit_page", method = RequestMethod.GET)
    public String editCategoryPage(Integer categoryId, Model model) {

        model.addAttribute("category", categoryService.get(categoryId));

        return "admin/edit/editCategory";
    }

    /**
     * 编辑栏目
     */
    @RequestMapping(value = "/admin_category_edit", method = RequestMethod.POST)
    public String editCategory(Category category) {
        categoryService.update(category);
        return "redirect:/admin/admin_category_list";
    }

    /**
     * 删除栏目
     */
    @RequestMapping(value = "/admin_category_delete", method = RequestMethod.GET)
    public String deleteCategory(Integer categoryId) {
        categoryService.delete(categoryId);
        return "redirect:/admin/admin_category_list";
    }
}
