package com.yunding.lago.bean;

public class ArticleWithBLOBs extends Article {
    private String keywords;

    private String content;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}