package com.mindnode.immipal.controller;

import com.alibaba.fastjson.JSON;
import com.mindnode.immipal.exception.object.NullObjectException;
import com.mindnode.immipal.pojo.News;
import com.mindnode.immipal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
@Controller
@RequestMapping("/detail")
public class DetailController {
    @Autowired
    NewsService newsService;

    /**新闻详情页内容*/
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String news(@RequestParam("newsId") Integer newsId) {
        Map<String, Object> data = new HashMap<>(2);
        News news  = null;
        try {
            news = newsService.getByNewsId(newsId);
        } catch (NullObjectException e) {
            data.put("message", e.getMessage());
        }
        data.put("news", news);
        return JSON.toJSONString(data);
    }
}
