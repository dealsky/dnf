package com.dealsky.dnf.service.impl;

import com.dealsky.dnf.dao.CommodityDetailsMapper;
import com.dealsky.dnf.pojo.CommodityDetails;
import com.dealsky.dnf.service.CommodityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dealsky
 * @Date: 2018/2/25 22:15
 */
@Service
public class CommodityDetailsServiceImpl implements CommodityDetailsService{

    @Autowired
    private CommodityDetailsMapper commodityDetailsMapper;

    @Override
    public int addCommDetails(CommodityDetails commodityDetails) {
        return commodityDetailsMapper.insert(commodityDetails);
    }

    @Override
    public List<CommodityDetails> selectByCmdNumber(Integer cmdNumber) {
        return commodityDetailsMapper.selectByCmdNumber(cmdNumber);
    }

    @Override
    public int updateByPrimaryKey(CommodityDetails commodityDetails) {
        return commodityDetailsMapper.updateByPrimaryKeySelective(commodityDetails);
    }

    @Override
    public int updateByCmdNumber(CommodityDetails commodityDetails) {
        return commodityDetailsMapper.updateByCmdNumberSelective(commodityDetails);
    }

    @Override
    public List<CommodityDetails> selectByCmdNumber(Integer cmdNumber, int status) {
        if (status == 1) {
            return commodityDetailsMapper.selectByCmdNumberLegal(cmdNumber);
        } else {
            return new ArrayList<>();
        }
    }

}
