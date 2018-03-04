package com.dealsky.dnf.controller;

import com.dealsky.dnf.pojo.Commodity;
import com.dealsky.dnf.pojo.CommodityDetails;
import com.dealsky.dnf.service.CommodityDetailsService;
import com.dealsky.dnf.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Author: dealsky
 * @Date: 2018/2/25 22:42
 */
@Controller
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    private CommodityDetailsService commodityDetailsService;

    @Autowired CommodityService commodityService;

    @RequestMapping(value = "{cmdId}", method = RequestMethod.GET)
    public String details() {

        return "details";

    }

    @RequestMapping(value = "{cmdId}/info", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> detailsInfo(@PathVariable Integer cmdId) {

        Map<String, Object> returnMap = new HashMap<>(16);

        List<CommodityDetails> commodityDetailsList = commodityDetailsService.selectByCmdNumber(cmdId, 1);

        if (commodityDetailsList.size() != 0) {
            returnMap.put("message", "ok");
            Commodity commodity = commodityService.selectByNumber(cmdId);
            returnMap.put("name", commodity.getCmdname());
            List<Map> list = new ArrayList<>();
            for (CommodityDetails commodityDetails : commodityDetailsList) {
                Map<String, Object> map = new HashMap<>();
                map.put("cmdDtNumber", commodityDetails.getCmddtnumber());
                map.put("cmdPrice", commodityDetails.getCmddtprice());
                map.put("cmdDtTime", commodityDetails.getCmddttime());
                list.add(map);
            }
            returnMap.put("info", list);
            return returnMap;
        } else {
            returnMap.put("message", "error");
            return returnMap;
        }

    }

    @RequestMapping(value = "{cmdId}", method = RequestMethod.POST)
    public @ResponseBody String addDetails(@PathVariable Integer cmdId, Integer cmdPrice) {

        CommodityDetails commodityDetails = new CommodityDetails();
        commodityDetails.setCmdnumber(cmdId);
        commodityDetails.setCmddtstatus(0);
        commodityDetails.setCmddtprice(cmdPrice);
        commodityDetails.setCmddttime(new Date());

        int ans = commodityDetailsService.addCommDetails(commodityDetails);

        if (ans == 1) {
            Commodity commodity = new Commodity();
            commodity.setCmdnumber(cmdId);
            commodity.setCmdprice(cmdPrice);
            commodity.setCmdtime(commodityDetails.getCmddttime());
            commodityService.updateByPrimaryKey(commodity);
            return "ok";
        } else {
            return "error";
        }

    }

}
