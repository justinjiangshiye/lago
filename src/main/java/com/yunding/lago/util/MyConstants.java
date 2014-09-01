package com.yunding.lago.util;

public class MyConstants {
	// Add user type
	public static Integer systemUser = 0;
	public static Integer anonymousUser = 1;
	public static Integer qqUser = 2;
	public static Integer weiboUser = 3;
	
	// Add session constrants
	public static String userTypeSessionKey = "userType";
	public static String accessTokenSessionKey = "accessToken";
	public static String accessTokenExpiredInSessionKey = "tgtexpiredin";
	public static String userLoginIdSessionKey = "loginId";
	public static String messageListSessionKey = "messageList";
	
	// Add menu item related id
	public static Integer menuItemHomeId = 1;
	public static Integer menuItem51Lago = 2;
	public static Integer menuItem51TingTing = 3;
	public static Integer menuItemParentSchoolId =4;
	public static Integer menuItemGrowUpId = 5;
	public static Integer menuItemLoveFamilyId = 6;
	public static Integer menuItemReadingId = 7;	
	public static Integer menuItemAboutId = 8;
	public static Integer menuItemSearchResultId = 9;
	
	// Add admin menu item related id
	public static Integer adminMenuItemHomeId = 101;
	public static Integer adminMenuItemArticleId = 102;
	public static Integer adminMenuItemFriendLinkId = 103;
	public static Integer adminMenuItemAboutId = 104;
	
	// Add article category related slugs url	
	public static String parentSchoolSlugsUrl = "parent-school";
	public static String growUpSlugsUrl = "grow-up";
	public static String loveFamilySlugsUrl = "love-family";
	public static String readingSlugsUrl = "reading";
	
	// Add article category related name
	public static String parentSchoolName = "父母学堂";
	public static String growUpName = "守护成长";
	public static String loveFamilyName = "我爱我家";
	public static String readingName = "亲子阅读";
	
	// Add static page category
	public static String category51lago = "51lago";
	public static String category51tingting = "51tingting";
	public static String categoryAboutUs = "aboutus";
	public static String categoryLagoSpirit = "lagospirit";
	public static String categoryUserGuide = "userguide";
	public static String categoryContactUs = "contactus";

	public static String getNameFromSlugsUrl(String slugsUrl) {
		if (slugsUrl.equals(parentSchoolSlugsUrl)) {
			return parentSchoolName;
		} else if (slugsUrl.equals(growUpSlugsUrl)) {
			return growUpName;
		} else if (slugsUrl.equals(loveFamilySlugsUrl)) {
			return loveFamilyName;
		} else if (slugsUrl.equals(readingSlugsUrl)) {
			return readingName;
		} else {
			return "";
		}
	}
	
	public static Integer getMenuItemIdFromSlugsUrl(String slugsUrl) {
		if (slugsUrl.equals(parentSchoolSlugsUrl)) {
			return menuItemParentSchoolId;
		} else if (slugsUrl.equals(growUpSlugsUrl)) {
			return menuItemGrowUpId;
		} else if (slugsUrl.equals(loveFamilySlugsUrl)) {
			return menuItemLoveFamilyId;
		} else if (slugsUrl.equals(readingSlugsUrl)) {
			return menuItemReadingId;
		} else {
			return menuItemHomeId;
		}
	}
	
	public static Integer getMenuItemIdFromCategoryName(String categoryName) {
		if (categoryName.equals(parentSchoolName)) {
			return menuItemParentSchoolId;
		} else if (categoryName.equals(growUpName)) {
			return menuItemGrowUpId;
		} else if (categoryName.equals(loveFamilyName)) {
			return menuItemLoveFamilyId;
		} else if (categoryName.equals(readingName)) {
			return menuItemReadingId;
		} else {
			return menuItemHomeId;
		}
	}
}
