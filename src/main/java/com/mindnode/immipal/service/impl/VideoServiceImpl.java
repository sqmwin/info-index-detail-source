package com.mindnode.immipal.service.impl;

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
    public Video get(int videoId){
        return  videoMapper.selectByPrimaryKey(videoId);
    }

    @Override
    public List<Video> listAll(){
        return  videoMapper.selectByExample(new VideoExample());
    }

    @Override
    public List<Video> listByNewsId(int newsId) {
        VideoExample example = new VideoExample();
        example.createCriteria().andNewsIdEqualTo(newsId);
        return videoMapper.selectByExample(example);
    }
}
