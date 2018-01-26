package com.mindnode.immipal.service.impl;

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
    public Ad get(int adId) {
        return adMapper.selectByPrimaryKey(adId);
    }

    @Override
    public Ad getFirstByAdLevel(int adLevel) {
        return listByAdLevel(adLevel).get(0);
    }

    @Override
    public List<Ad> listByAdLevel(int adLevel) {
        AdExample example = new AdExample();
        example.createCriteria().andAdLevelEqualTo(adLevel);
        return adMapper.selectByExample(example);
    }

    @Override
    public List<Ad> listAll() {
        return adMapper.selectByExample(new AdExample());
    }

    @Override
    public List<Ad> listAllOrderByLevel() {
        AdExample example = new AdExample();
        example.setOrderByClause("ad_level");
        return adMapper.selectByExample(example);
    }
}
