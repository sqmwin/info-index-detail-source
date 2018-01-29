package com.mindnode.immipal.service.impl;

import com.mindnode.immipal.exception.list.NullListException;
import com.mindnode.immipal.exception.object.NullObjectException;
import com.mindnode.immipal.mapper.VideoMapper;
import com.mindnode.immipal.pojo.Video;
import com.mindnode.immipal.pojo.VideoExample;
import com.mindnode.immipal.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/28
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;
    @Override
    public void add(Video video) {
        videoMapper.insert(video);
    }

    @Override
    public void delete(int videoId) {
        videoMapper.deleteByPrimaryKey(videoId);
    }

    @Override
    public Video get(int videoId) throws NullObjectException {
        Video video = videoMapper.selectByPrimaryKey(videoId);
        if (video == null) {
            throw new NullObjectException("没有视频：" + videoId);
        }
        return video;
    }

    @Override
    public List<Video> listAll() throws NullListException {
        List<Video> videoList = videoMapper.selectByExample(new VideoExample());
        if (videoList == null) {
            throw new NullListException("没有视频");
        }
        return videoList;
    }
}
