package com.yunding.lago.bean;

import java.util.Date;

public class BulletinBoard {
    private Integer id;

    private String summary;

    private Integer order;

    private Boolean ispublished;

    private Date publishdate;

    private Date createdon;

    private Integer recordstatus;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getIspublished() {
        return ispublished;
    }

    public void setIspublished(Boolean ispublished) {
        this.ispublished = ispublished;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}