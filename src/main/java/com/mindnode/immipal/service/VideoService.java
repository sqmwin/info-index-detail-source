package com.mindnode.immipal.service;

import com.mindnode.immipal.exception.list.NullListException;
import com.mindnode.immipal.exception.object.NullObjectException;
import com.mindnode.immipal.pojo.Video;

import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/28
 */
public interface VideoService {
    void add(Video video);

    void delete(int videoId);

    Video get(int videoId) throws NullObjectException;

    List<Video> listAll() throws NullListException;

}
