package com.mindnode.immipal.service.impl;

import com.mindnode.immipal.mapper.PicMapper;
import com.mindnode.immipal.pojo.Pic;
import com.mindnode.immipal.pojo.PicExample;
import com.mindnode.immipal.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/28
 */
@Service
public class PicServiceImpl implements PicService {
    @Autowired
    PicMapper picMapper;

    @Override
    public void add(Pic pic) {
        picMapper.insert(pic);
    }

    @Override
    public void delete(int picId) {
        picMapper.deleteByPrimaryKey(picId);
    }

    @Override
    public Pic get(int picId){
        return picMapper.selectByPrimaryKey(picId);
    }

    @Override
    public List<Pic> listAll(){
        return picMapper.selectByExample(new PicExample());
    }
}
