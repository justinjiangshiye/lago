package com.yunding.lago.bean;

import java.util.Date;

public class ShareStat {
    private Integer id;

    private Integer articleid;

    private Integer userid;

    private String thridpartyname;

    private String thirdpartylink;

    private Date createdon;

    private Integer recordstatus;

    private String sharedcontent;

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getThridpartyname() {
        return thridpartyname;
    }

    public void setThridpartyname(String thridpartyname) {
        this.thridpartyname = thridpartyname;
    }

    public String getThirdpartylink() {
        return thirdpartylink;
    }

    public void setThirdpartylink(String thirdpartylink) {
        this.thirdpartylink = thirdpartylink;
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

    public String getSharedcontent() {
        return sharedcontent;
    }

    public void setSharedcontent(String sharedcontent) {
        this.sharedcontent = sharedcontent;
    }
}