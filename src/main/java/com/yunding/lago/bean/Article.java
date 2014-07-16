package com.yunding.lago.bean;

import java.util.Date;

public class Article {
    private Integer id;

	private String category;

	private String title;

	private String slugsurl;

	private String bannerurl;

	private String abstractcontent;

	private Boolean isdisplayonhome;

	private Boolean islocktop;

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

	public String getSlugsurl() {
		return slugsurl;
	}

	public void setSlugsurl(String slugsurl) {
		this.slugsurl = slugsurl;
	}

	public String getBannerurl() {
		return bannerurl;
	}

	public void setBannerurl(String bannerurl) {
		this.bannerurl = bannerurl;
	}

	public String getAbstractcontent() {
		return abstractcontent;
	}

	public void setAbstractcontent(String abstractcontent) {
		this.abstractcontent = abstractcontent;
	}

	public Boolean getIsdisplayonhome() {
		return isdisplayonhome;
	}

	public void setIsdisplayonhome(Boolean isdisplayonhome) {
		this.isdisplayonhome = isdisplayonhome;
	}

	public Boolean getIslocktop() {
		return islocktop;
	}

	public void setIslocktop(Boolean islocktop) {
		this.islocktop = islocktop;
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