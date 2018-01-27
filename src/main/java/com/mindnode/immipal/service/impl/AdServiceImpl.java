package com.mindnode.immipal.service.impl;

import com.mindnode.immipal.exception.list.NullListException;
import com.mindnode.immipal.exception.object.NullObjectException;
import com.mindnode.immipal.mapper.AdMapper;
import com.mindnode.immipal.pojo.Ad;
import com.mindnode.immipal.pojo.AdExample;
import com.mindnode.immipal.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    AdMapper adMapper;

    @Override
    public void add(Ad ad) {
        adMapper.insert(ad);
    }

    @Override
    public void delete(int adId) {
        adMapper.deleteByPrimaryKey(adId);
    }

    @Override
    public void update(Ad ad) {
        adMapper.updateByPrimaryKey(ad);
    }

    @Override
    public Ad get(int adId) throws NullObjectException {
        Ad ad = adMapper.selectByPrimaryKey(adId);
        if (ad == null) {
            throw new NullObjectException("无此广告");
        }
        return ad;
    }

    @Override
    public Ad getFirstByAdLevel(int adLevel) throws NullObjectException,NullListException{
        Ad ad = listByAdLevel(adLevel).get(0);
        if (ad == null) {
            throw new NullObjectException("无此广告");
        }
        return ad;
    }

    @Override
    public List<Ad> listByAdLevel(int adLevel) throws NullListException{
        AdExample example = new AdExample();
        example.createCriteria().andAdLevelEqualTo(adLevel);
        List<Ad> adList = adMapper.selectByExample(example);
        if (adList == null) {
            throw new NullListException("此广告列表为空");
        }
        return adList;
    }

    @Override
    public List<Ad> listAll() throws NullListException {
        List<Ad> adList = adMapper.selectByExample(new AdExample());
        if (adList == null) {
            throw new NullListException("此广告列表为空");
        }
        return adList;
    }

    @Override
    public List<Ad> listAllOrderByLevel() throws NullListException {

        AdExample example = new AdExample();
        example.setOrderByClause("ad_level");
        List<Ad> adList = adMapper.selectByExample(example);
        if (adList == null) {
            throw new NullListException("此广告列表为空");
        }
        return adList;
    }
}
