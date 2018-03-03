package com.dealsky.dnf.service;

import com.dealsky.dnf.pojo.CommodityDetails;

import java.util.List;

/**
 * @Author: dealsky
 * @Date: 2018/2/25 22:15
 */
public interface CommodityDetailsService {

    /**
     * 增加一条商品信息
     * @param commodityDetails
     * @return 成功: 1, 失败: 0
     */
    int addCommDetails(CommodityDetails commodityDetails);

    /**
     * 根据商品编号查询商品信息
     * @param cmdNumber
     * @return
     */
    List<CommodityDetails> selectByCmdNumber(Integer cmdNumber);

    /**
     * 根据主键更新
     * @param commodityDetails
     * @return
     */
    int updateByPrimaryKey(CommodityDetails commodityDetails);

}
