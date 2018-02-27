package com.dealsky.dnf.service;

import com.dealsky.dnf.pojo.Commodity;

import java.util.List;

/**
 * @Author: dealsky
 */
public interface CommodityService {

    /**
     * 返回所有的商品信息
     * @return
     */
    List<Commodity> listCommodity();

    /**
     * 增加一条商品记录
     * @param commodity
     * @return 成功: 1, 失败: 0
     */
    int addCommodity(Commodity commodity);

    /**
     * 判断商品名是否合法
     * @param cmdName
     * @return 合法: true, 非法: false
     */
    boolean judgeCmdName(String cmdName);

    /**
     * 根据商品编号查找商品
     * @param cmdNumber
     * @return
     */
    Commodity selectByNumber(Integer cmdNumber);

    /**
     * 根据主键更新商品
     * @param primaryKey
     * @return 成功: 1, 失败: 0
     */
    int updateByPrimaryKey(Commodity commodity);

}
