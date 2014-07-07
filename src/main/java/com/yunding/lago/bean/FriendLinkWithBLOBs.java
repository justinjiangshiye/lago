package com.yunding.lago.bean;

public class FriendLinkWithBLOBs extends FriendLink {
    private String websiteurl;

    private String logourl;

    public String getWebsiteurl() {
        return websiteurl;
    }

    public void setWebsiteurl(String websiteurl) {
        this.websiteurl = websiteurl;
    }

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }
}