package com.mindnode.immipal.service.impl;

import com.mindnode.immipal.exception.list.NullListException;
import com.mindnode.immipal.exception.object.NullObjectException;
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
public class CategoryServiceImpl implements CategoryService  {
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
    public Category get(int categoryId) throws NullObjectException {
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category == null) {
            throw new NullObjectException("无此栏目");
        }
        return category;
    }

    @Override
    public List<Category> listAll() throws NullListException {
        List<Category> categoryList = categoryMapper.selectByExample(new CategoryExample());
        if (categoryList == null) {
            throw new NullListException("此栏目列表为空");
        }
        return categoryList;
    }

    @Override
    public List<Category> listAllOrderByLevel() throws NullListException{
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("category_level");
        List<Category> categoryList = categoryMapper.selectByExample(example);
        if (categoryList == null) {
            throw new NullListException("此栏目列表为空");
        }
        return categoryList;
    }
}
