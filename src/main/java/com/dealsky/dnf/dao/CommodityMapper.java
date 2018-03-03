package com.dealsky.dnf.dao;

import com.dealsky.dnf.pojo.Commodity;

import java.util.List;

/**
 * @Author: dealsky
 */
public interface CommodityMapper {
    int deleteByPrimaryKey(Integer cmdnumber);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    Commodity selectByPrimaryKey(Integer cmdnumber);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKeyWithBLOBs(Commodity record);

    int updateByPrimaryKey(Commodity record);

    List<Commodity> listCommodity();

    List<Commodity> selectByCmdName(String cmdName);

    List<Commodity> listCommodityLegal();

}