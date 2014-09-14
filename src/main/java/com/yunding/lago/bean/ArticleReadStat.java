package com.yunding.lago.bean;

import java.util.Date;

public class ArticleReadStat {
    private Integer id;

    private Integer articleid;

    private String userloginid;

    private String ip;

    private String sessionid;

    private Date createdon;

    private Integer recordstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getUserloginid() {
        return userloginid;
    }

    public void setUserloginid(String userloginid) {
        this.userloginid = userloginid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
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