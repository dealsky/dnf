package com.dealsky.dnf.controller;

import com.dealsky.dnf.pojo.Commodity;
import com.dealsky.dnf.pojo.CommodityDetails;
import com.dealsky.dnf.pojo.User;
import com.dealsky.dnf.service.CommodityDetailsService;
import com.dealsky.dnf.service.CommodityService;
import com.dealsky.dnf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Author: dealsky
 */
@Controller
@RequestMapping("/index")
public class CmdController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private CommodityDetailsService commodityDetailsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {

        return "index";

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<Commodity> listCommodity() {

        return commodityService.listCommodityLegal();

    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public @ResponseBody String addCommodity(String cmdName, Integer cmdPrice) {

        if (!commodityService.judgeCmdName(cmdName)) {
            return "name";
        }

        Commodity commodity = new Commodity();
        commodity.setCmdname(cmdName);
        commodity.setCmdprice(cmdPrice);
        commodity.setCmdtime(new Date());
        commodity.setCmdstatus(0);
        commodity.setCmdpriority(0);

        int ans = commodityService.addCommodity(commodity);

        if (ans == 1) {
            CommodityDetails commodityDetails = new CommodityDetails();
            commodityDetails.setCmdnumber(commodity.getCmdnumber());
            commodityDetails.setCmddtprice(commodity.getCmdprice());
            commodityDetails.setCmddtstatus(commodity.getCmdstatus());
            commodityDetails.setCmddttime(commodity.getCmdtime());
            commodityDetailsService.addCommDetails(commodityDetails);
            return "ok";
        } else {
            return "error";
        }

    }

    @RequestMapping(value = "/list", method = RequestMethod.PUT)
    public @ResponseBody String updateCommodityName(Integer cmdNumber, String cmdName) {

        if (!commodityService.judgeCmdName(cmdName)) {
            return "name";
        }

        Commodity commodity = new Commodity();
        commodity.setCmdnumber(cmdNumber);
        commodity.setCmdname(cmdName);
        int ans = commodityService.updateByPrimaryKey(commodity);
        if (ans == 1) {
            return "ok";
        } else {
            return "error";
        }

    }

    @RequestMapping(value = "/list", method = RequestMethod.DELETE)
    public @ResponseBody String deleteCommodity(Integer cmdNumber) {

        Commodity commodity = new Commodity();
        commodity.setCmdnumber(cmdNumber);
        commodity.setCmdstatus(1);

        int ans = commodityService.updateByPrimaryKey(commodity);

        if (ans == 1) {
            CommodityDetails commodityDetails = new CommodityDetails();
            commodityDetails.setCmdnumber(cmdNumber);
            commodityDetails.setCmddtstatus(1);
            commodityDetailsService.updateByCmdNumber(commodityDetails);
            return "ok";
        } else {
            return "error";
        }

    }


}
