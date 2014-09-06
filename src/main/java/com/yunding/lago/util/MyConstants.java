package com.yunding.lago.util;

public class MyConstants {
	// Add config key
	public static String configWebsiteUrl = "website_url";
	public static String configWebsiteUploadFolder = "website_uploadFolder";
	public static String configWebsiteDownloadUrlPrefix = "website_downloadUrlPrefix";
	
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
	public static String AdminLoginedKey = "adminLogined";
	
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
	public static Integer adminMenuItemHomeId = 100;
	public static Integer adminMenuItemBulletinBoardId = 101;
	public static Integer adminMenuItemBannerLinkId = 102;
	public static Integer adminMenuItemStaticPageId = 103;
	public static Integer adminMenuItemParentSchoolId = 104;
	public static Integer adminMenuItemGrowUpId = 105;
	public static Integer adminMenuItemLoveFamilyId = 106;
	public static Integer adminMenuItemReadingId = 107;
	public static Integer adminMenuItemIndexBuildId = 108;
	public static Integer adminMenuItemFriendLinkId = 109;
	public static Integer adminMenuItemUsersId = 110;
	
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
	
	public static String getSlugsUrlFromName(String categoryName) {
		if (categoryName.equals(parentSchoolName)) {
			return parentSchoolSlugsUrl;
		} else if (categoryName.equals(growUpName)) {
			return growUpSlugsUrl;
		} else if (categoryName.equals(loveFamilyName)) {
			return loveFamilySlugsUrl;
		} else if (categoryName.equals(readingName)) {
			return readingSlugsUrl;
		} else {
			return "";
		}
	}
	
	public static Integer getAdminMenuItemIdFromSlugsUrl(String slugsUrl) {
		if (slugsUrl.equals(parentSchoolSlugsUrl)) {
			return adminMenuItemParentSchoolId;
		} else if (slugsUrl.equals(growUpSlugsUrl)) {
			return adminMenuItemGrowUpId;
		} else if (slugsUrl.equals(loveFamilySlugsUrl)) {
			return adminMenuItemLoveFamilyId;
		} else if (slugsUrl.equals(readingSlugsUrl)) {
			return adminMenuItemReadingId;
		} else {
			return adminMenuItemHomeId;
		}
	}
	
	public static Integer getAdminMenuItemIdFromCategoryName(String categoryName) {
		if (categoryName.equals(parentSchoolName)) {
			return adminMenuItemParentSchoolId;
		} else if (categoryName.equals(growUpName)) {
			return adminMenuItemGrowUpId;
		} else if (categoryName.equals(loveFamilyName)) {
			return adminMenuItemLoveFamilyId;
		} else if (categoryName.equals(readingName)) {
			return adminMenuItemReadingId;
		} else {
			return adminMenuItemHomeId;
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
