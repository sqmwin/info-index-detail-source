package com.mindnode.immipal.service;

import com.mindnode.immipal.pojo.Pic;

import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/28
 */
public interface PicService {
    void add(Pic pic);

    void delete(int picId);

    Pic get(int picId);

    List<Pic> listAll();
}
