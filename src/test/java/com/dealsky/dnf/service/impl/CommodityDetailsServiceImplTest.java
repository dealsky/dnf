package com.dealsky.dnf.service.impl;

import com.dealsky.dnf.pojo.CommodityDetails;
import com.dealsky.dnf.service.CommodityDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @Author: dealsky
 * @Date: 2018/2/26 9:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommodityDetailsServiceImplTest {

    @Autowired
    private CommodityDetailsService commodityDetailsService;

    @Test
    public void addCommDetails() throws InterruptedException {
        /*Random random = new Random();
        for (int i = 1; i<=20; i++) {
            CommodityDetails commodityDetails = new CommodityDetails();
            Integer cmdPrice =  Math.abs(random.nextInt()) % 20 + 50;
            commodityDetails.setCmddtprice(cmdPrice);
            commodityDetails.setCmddtstatus(0);
            commodityDetails.setCmdnumber(10001);
            commodityDetails.setCmddttime(new Date());
            int log = commodityDetailsService.addCommDetails(commodityDetails);
            System.out.println(log);
            Thread.currentThread().sleep(1000);
        }*/
    }

    @Test
    public void selectByCmdNumber() {
        List<CommodityDetails> list = commodityDetailsService.selectByCmdNumber(10001);
        for (CommodityDetails commodityDetails : list) {
            System.out.println(commodityDetails.getCmddtnumber());
        }
    }

    @Test
    public void updateByCmdNumber() {

        CommodityDetails commodityDetails = new CommodityDetails();
        commodityDetails.setCmdnumber(10001);
        commodityDetails.setCmddtstatus(0);

        int ans = commodityDetailsService.updateByCmdNumber(commodityDetails);

        System.out.println(ans);

    }

    @Test
    public void selectByCmdNumber2() {

        List<CommodityDetails> list = commodityDetailsService.selectByCmdNumber(10001, 0);

        System.out.println(list.size());

        for (CommodityDetails commodityDetails : list) {
            System.out.println(commodityDetails.getCmddtnumber());
        }

    }

}