package com.dealsky.dnf.service.impl;

import com.dealsky.dnf.dao.CommodityMapper;
import com.dealsky.dnf.pojo.Commodity;
import com.dealsky.dnf.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Author: dealsky
*/
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public List<Commodity> listCommodity() {
        return commodityMapper.listCommodity();
    }

    @Override
    public int addCommodity(Commodity commodity) {
        return commodityMapper.insert(commodity);
    }

    @Override
    public boolean judgeCmdName(String cmdName) {
        List<Commodity> list = commodityMapper.selectByCmdName(cmdName);
        if (list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Commodity selectByNumber(Integer cmdNumber) {
        return commodityMapper.selectByPrimaryKey(cmdNumber);
    }

    @Override
    public int updateByPrimaryKey(Commodity commodity) {
        return commodityMapper.updateByPrimaryKeySelective(commodity);
    }

    @Override
    public List<Commodity> listCommodityLegal() {
        return commodityMapper.listCommodityLegal();
    }
}
