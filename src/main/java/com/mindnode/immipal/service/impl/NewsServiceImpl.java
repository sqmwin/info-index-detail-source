package com.mindnode.immipal.service.impl;

import com.mindnode.immipal.exception.list.NullListException;
import com.mindnode.immipal.exception.object.NullObjectException;
import com.mindnode.immipal.mapper.NewsMapper;
import com.mindnode.immipal.pojo.News;
import com.mindnode.immipal.pojo.NewsExample;
import com.mindnode.immipal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;
    @Override
    public void add(News news) {
        newsMapper.insert(news);
    }

    @Override
    public void delete(int newsId) {
        newsMapper.deleteByPrimaryKey(newsId);
    }

    @Override
    public void update(News news) {
        newsMapper.updateByPrimaryKey(news);
    }

    @Override
    public void setNewsTopInCategory(int topNewsId) {
        //获取要置顶的news对象
        News topNews = newsMapper.selectByPrimaryKey(topNewsId);

        int categoryId = topNews.getCategoryId();

        //获取并遍历此置顶news对象所在的categoryId分类
        NewsExample example = new NewsExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        List<News> newsList = newsMapper.selectByExample(example);
        for (News news : newsList) {
            //判断当为此分类中其他对象时，若newsTop值为true，则改为false，更新到数据库；
            //且同时设置要置顶的对象newsTop值为true，更新到数据库；
            if (topNewsId != news.getNewsId() && news.getNewsTop()) {
                news.setNewsTop(false);
                newsMapper.updateByPrimaryKey(news);
                topNews.setNewsTop(true);
                newsMapper.updateByPrimaryKey(topNews);
                return;
            }
        }
    }

    @Override
    public News getByNewsId(int newsId)throws NullObjectException {
        News news = newsMapper.selectByPrimaryKey(newsId);
        if (news == null) {
            throw new NullObjectException("无此新闻");
        }
        return news;
    }

    @Override
    public List<News> listByNewsTopTrueAndCategoryId(int categoryId){
        NewsExample example = new NewsExample();
        example.createCriteria().andNewsTopEqualTo(true).andCategoryIdEqualTo(categoryId);
        return newsMapper.selectByExample(example);
    }

    @Override
    public List<News> listAll() throws NullListException {
        List<News> newsList = newsMapper.selectByExample(new NewsExample());
        if (newsList == null) {
            throw new NullListException("此新闻列表为空");
        }
        return newsList;
    }

    @Override
    public List<News> listAllOrderByCreateTime() throws NullListException{
        NewsExample example = new NewsExample();
        example.setOrderByClause("news_create_time desc");
        List<News> newsList = newsMapper.selectByExample(example);
        if (newsList == null) {
            throw new NullListException("此新闻列表为空");
        }
        return newsList;
    }

    @Override
    public List<News> listByRecommend() throws NullListException{
        NewsExample example = new NewsExample();
        example.createCriteria().andRecommendEqualTo(true);
        example.setOrderByClause("news_create_time desc");
        List<News> newsList = newsMapper.selectByExample(example);
        if (newsList == null) {
            throw new NullListException("此新闻列表为空");
        }
        return newsList;
    }

    @Override
    public List<News> listByCategoryId(int categoryId) throws NullListException {
        NewsExample example = new NewsExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        example.setOrderByClause("news_create_time desc");
        List<News> newsList = newsMapper.selectByExample(example);
        if (newsList == null) {
            throw new NullListException("此新闻列表为空");
        }
        return newsList;
    }
}
