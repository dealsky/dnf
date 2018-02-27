package com.dealsky.dnf.pojo;

import java.util.Date;

public class CommodityDetails {
    private Integer cmddtnumber;

    private Integer cmdnumber;

    private Integer cmddtprice;

    private Integer cmddtstatus;

    private Date cmddttime;

    public Integer getCmddtnumber() {
        return cmddtnumber;
    }

    public void setCmddtnumber(Integer cmddtnumber) {
        this.cmddtnumber = cmddtnumber;
    }

    public Integer getCmdnumber() {
        return cmdnumber;
    }

    public void setCmdnumber(Integer cmdnumber) {
        this.cmdnumber = cmdnumber;
    }

    public Integer getCmddtprice() {
        return cmddtprice;
    }

    public void setCmddtprice(Integer cmddtprice) {
        this.cmddtprice = cmddtprice;
    }

    public Integer getCmddtstatus() {
        return cmddtstatus;
    }

    public void setCmddtstatus(Integer cmddtstatus) {
        this.cmddtstatus = cmddtstatus;
    }

    public Date getCmddttime() {
        return cmddttime;
    }

    public void setCmddttime(Date cmddttime) {
        this.cmddttime = cmddttime;
    }
}