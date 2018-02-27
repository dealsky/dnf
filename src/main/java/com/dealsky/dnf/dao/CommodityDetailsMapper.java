package com.dealsky.dnf.dao;

import com.dealsky.dnf.pojo.CommodityDetails;

import java.util.List;

/**
 * @author dealsky
 */
public interface CommodityDetailsMapper {
    int deleteByPrimaryKey(Integer cmddtnumber);

    int insert(CommodityDetails record);

    int insertSelective(CommodityDetails record);

    CommodityDetails selectByPrimaryKey(Integer cmddtnumber);

    int updateByPrimaryKeySelective(CommodityDetails record);

    int updateByPrimaryKey(CommodityDetails record);

    List<CommodityDetails> selectByCmdNumber(Integer cmdNumber);
}