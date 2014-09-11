package com.yunding.lago.bean;

public class AppDownloadWithBLOBs extends AppDownload {
    private String iosqrcodeurl;

    private String iosdownloadurl;

    private String androidqrcodeurl;

    private String androiddownloadurl;

    public String getIosqrcodeurl() {
        return iosqrcodeurl;
    }

    public void setIosqrcodeurl(String iosqrcodeurl) {
        this.iosqrcodeurl = iosqrcodeurl;
    }

    public String getIosdownloadurl() {
        return iosdownloadurl;
    }

    public void setIosdownloadurl(String iosdownloadurl) {
        this.iosdownloadurl = iosdownloadurl;
    }

    public String getAndroidqrcodeurl() {
        return androidqrcodeurl;
    }

    public void setAndroidqrcodeurl(String androidqrcodeurl) {
        this.androidqrcodeurl = androidqrcodeurl;
    }

    public String getAndroiddownloadurl() {
        return androiddownloadurl;
    }

    public void setAndroiddownloadurl(String androiddownloadurl) {
        this.androiddownloadurl = androiddownloadurl;
    }
}