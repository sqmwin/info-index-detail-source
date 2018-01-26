package com.mindnode.immipal.service.impl;

import com.mindnode.immipal.mapper.CategoryMapper;
import com.mindnode.immipal.pojo.Category;
import com.mindnode.immipal.pojo.CategoryExample;
import com.mindnode.immipal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void delete(int categoryId) {
        categoryMapper.deleteByPrimaryKey(categoryId);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public Category get(int categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public List<Category> listAll() {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public List<Category> listAllOrderByLevel() {
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("ad_level");
        return categoryMapper.selectByExample(example);
    }
}
