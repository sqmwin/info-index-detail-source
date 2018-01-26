package com.mindnode.immipal.service;

import com.mindnode.immipal.pojo.Category;

import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */

public interface CategoryService {

    void add(Category category);

    void delete(int categoryId);

    void update(Category category);

    Category get(int categoryId);

    List<Category> listAll();

    /**排序方式：根据category_level从小到大排序*/
    List<Category> listAllOrderByLevel();
}
