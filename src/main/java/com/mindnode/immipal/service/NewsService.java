package com.mindnode.immipal.service;

import com.mindnode.immipal.exception.list.NullListException;
import com.mindnode.immipal.exception.object.NullObjectException;
import com.mindnode.immipal.pojo.News;

import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
public interface NewsService {

    void add(News news);

    void delete(int newsId);

    void update(News news);

    /**
     * 设置指定的news对象在其所属分类中置顶
     */
    void setNewsTopInCategory(int topNewsId);

    /**
     * 根据newsId返回News对象
     */
    News getByNewsId(int newsId) throws NullObjectException;

    /**
     * 根据newsTop为true且指定categoryId中的news对象
     */
    List<News> listByNewsTopTrueAndCategoryId(int categoryId);

    /**
     * 返回全部新闻，通过时间long值从大到小排序
     */
    List<News> listAll() throws NullListException;

    /**
     * 返回所有新闻，通过时间long值从大到小排序
     */
    List<News> listAllOrderByCreateTime() throws NullListException;

    /**
     * 返回推荐列表，通过时间long值从大到小排序
     */
    List<News> listByRecommend() throws NullListException;

    /**
     * 通过分类id返回新闻列表，通过时间long值从大到小排序
     */
    List<News> listByCategoryId(int categoryId) throws NullListException;

}
