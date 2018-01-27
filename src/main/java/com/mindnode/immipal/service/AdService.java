package com.mindnode.immipal.service;

import com.mindnode.immipal.exception.list.NullListException;
import com.mindnode.immipal.exception.object.NullObjectException;
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

    Ad get(int adId) throws NullObjectException;

    /**根据广告等级返回，每个等级只能有一条广告*/
    Ad getFirstByAdLevel(int adLevel) throws NullObjectException,NullListException;

    List<Ad> listByAdLevel(int adLevel) throws NullListException;

    List<Ad> listAll() throws NullListException;

    /**根据ad_level值从小到大排序*/
    List<Ad> listAllOrderByLevel() throws NullListException;
}
