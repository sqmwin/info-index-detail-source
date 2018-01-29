package com.mindnode.immipal.service;

import com.mindnode.immipal.exception.list.NullListException;
import com.mindnode.immipal.exception.object.NullObjectException;
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

    Pic get(int picId) throws NullObjectException;

    List<Pic> listAll() throws NullListException;
}
