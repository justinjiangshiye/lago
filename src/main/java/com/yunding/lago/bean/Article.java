package com.yunding.lago.bean;

import java.util.Date;

public class Article {
    private Integer id;

    private String category;

    private String title;

    private String bannerurl;

    private String abstract;

    private Integer order;

    private Boolean ispublished;

    private Date publishdate;

    private Date createdon;

    private Integer recordstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBannerurl() {
        return bannerurl;
    }

    public void setBannerurl(String bannerurl) {
        this.bannerurl = bannerurl;
    }

    public String getAbstract() {
        return abstract;
    }

    public void setAbstract(String abstract) {
        this.abstract = abstract;
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
}