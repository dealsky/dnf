package com.dealsky.dnf.pojo;

import java.util.Date;

public class Commodity {
    private Integer cmdnumber;

    private Integer cmdprice;

    private Integer cmdstatus;

    private Integer cmdpriority;

    private Date cmdtime;

    private String cmdname;

    public Integer getCmdnumber() {
        return cmdnumber;
    }

    public void setCmdnumber(Integer cmdnumber) {
        this.cmdnumber = cmdnumber;
    }

    public Integer getCmdprice() {
        return cmdprice;
    }

    public void setCmdprice(Integer cmdprice) {
        this.cmdprice = cmdprice;
    }

    public Integer getCmdstatus() {
        return cmdstatus;
    }

    public void setCmdstatus(Integer cmdstatus) {
        this.cmdstatus = cmdstatus;
    }

    public Integer getCmdpriority() {
        return cmdpriority;
    }

    public void setCmdpriority(Integer cmdpriority) {
        this.cmdpriority = cmdpriority;
    }

    public Date getCmdtime() {
        return cmdtime;
    }

    public void setCmdtime(Date cmdtime) {
        this.cmdtime = cmdtime;
    }

    public String getCmdname() {
        return cmdname;
    }

    public void setCmdname(String cmdname) {
        this.cmdname = cmdname == null ? null : cmdname.trim();
    }
}