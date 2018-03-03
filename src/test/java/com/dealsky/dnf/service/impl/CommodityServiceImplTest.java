package com.dealsky.dnf.service.impl;

import com.dealsky.dnf.dao.CommodityMapper;
import com.dealsky.dnf.pojo.Commodity;
import com.dealsky.dnf.service.CommodityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: dealsky
 * @Date: 2018/2/25 21:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommodityServiceImplTest {

    @Autowired
    private CommodityService commodityService;

    @Test
    public void listCommodity() {
    }

    @Test
    public void addCommodity() {
    }

    @Test
    public void judgeCmdName() {
        boolean flag = commodityService.judgeCmdName("Cmd-Aa");
        System.out.println(flag);
    }

    @Test
    public void listCommodityLegal() {
        List<Commodity> list = commodityService.listCommodityLegal();
        for (Commodity commodity : list) {
            System.out.println(commodity.getCmdname());
        }
    }

}