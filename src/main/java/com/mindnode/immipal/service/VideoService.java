package com.mindnode.immipal.service;

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

    Video get(int videoId);

    List<Video> listAll();

    List<Video> listByNewsId(int newsId);
}
