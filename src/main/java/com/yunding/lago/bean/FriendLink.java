package com.yunding.lago.bean;

import java.util.Date;

public class FriendLink {
    private Integer id;

    private String websitename;

    private Integer order;

    private Date createdon;

    private Integer recordstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebsitename() {
        return websitename;
    }

    public void setWebsitename(String websitename) {
        this.websitename = websitename;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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