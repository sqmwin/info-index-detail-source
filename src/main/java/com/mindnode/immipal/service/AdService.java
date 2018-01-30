package com.mindnode.immipal.service;

import com.mindnode.immipal.pojo.Ad;

import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
public interface AdService {
    void add(Ad ad);

    void delete(int adId);

    void update(Ad ad);

    Ad get(int adId);

    /**根据广告等级返回，每个等级只能有一条广告*/
    Ad getFirstByAdLevel(int adLevel);

    List<Ad> listByAdLevel(int adLevel);

    List<Ad> listAll();

    /**根据ad_level值从小到大排序*/
    List<Ad> listAllOrderByLevel();
}
