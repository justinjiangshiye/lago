package com.yunding.lago.bean;

import java.util.Date;

public class AppDownload {
    private Integer id;

    private String appname;

    private Boolean isiosapppublished;

    private Boolean isandroidapppublished;

    private Date createdon;

    private Integer recordstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public Boolean getIsiosapppublished() {
        return isiosapppublished;
    }

    public void setIsiosapppublished(Boolean isiosapppublished) {
        this.isiosapppublished = isiosapppublished;
    }

    public Boolean getIsandroidapppublished() {
        return isandroidapppublished;
    }

    public void setIsandroidapppublished(Boolean isandroidapppublished) {
        this.isandroidapppublished = isandroidapppublished;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public Integer getRecordstatus() {
        return recordstatus;
    }

    public void setRecordstatus(Integer recordstatus) {
        this.recordstatus = recordstatus;
    }
}