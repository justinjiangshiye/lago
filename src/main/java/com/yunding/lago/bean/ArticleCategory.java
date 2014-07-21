package com.yunding.lago.bean;

public class ArticleCategory {
	public static String parentSchoolSlugsUrl = "parent-school";
	public static String growUpSlugsUrl = "grow-up";
	public static String loveFamilySlugsUrl = "love-family";
	public static String readingSlugsUrl = "reading";
	
	public static String getNameFromSlugsUrl(String slugsUrl) {
		if (slugsUrl == parentSchoolSlugsUrl) {
			return "父母学堂";
		} else if (slugsUrl == growUpSlugsUrl) {
			return "守护成长";
		} else if (slugsUrl == loveFamilySlugsUrl) {
			return "我爱我家";
		} else if (slugsUrl == readingSlugsUrl) {
			return "亲子阅读";
		} else {
			return "";
		}
	}
}
