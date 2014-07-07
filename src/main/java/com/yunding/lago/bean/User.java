package com.yunding.lago.bean;

import java.util.Date;

public class User {
    private Integer id;

    private Integer type;

    private String loginid;

    private String nickname;

    private String password;

    private Date registeron;

    private Date lastvisiton;

    private Date createdon;

    private Integer recordstatus;

    private String profilephotourl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisteron() {
        return registeron;
    }

    public void setRegisteron(Date registeron) {
        this.registeron = registeron;
    }

    public Date getLastvisiton() {
        return lastvisiton;
    }

    public void setLastvisiton(Date lastvisiton) {
        this.lastvisiton = lastvisiton;
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

    public String getProfilephotourl() {
        return profilephotourl;
    }

    public void setProfilephotourl(String profilephotourl) {
        this.profilephotourl = profilephotourl;
    }
}