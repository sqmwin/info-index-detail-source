package com.mindnode.immipal.service.impl;

import com.mindnode.immipal.exception.list.NullListException;
import com.mindnode.immipal.exception.object.NullObjectException;
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
    public Pic get(int picId) throws NullObjectException {
        Pic pic = picMapper.selectByPrimaryKey(picId);
        if (pic == null) {
            throw new NullObjectException("没有此图片：" + picId);
        }
        return pic;
    }

    @Override
    public List<Pic> listAll() throws NullListException {
        List<Pic> picList = picMapper.selectByExample(new PicExample());
        if (picList == null) {
            throw new NullListException("没有图片");
        }
        return picList;
    }
}
