package com.yunding.lago.bean;

public class MyConstants {
	// Add menu item related id
	public static Integer menuItemHomeId = 1;
	public static Integer menuItemParentSchoolId =4;
	public static Integer menuItemGrowUpId = 5;
	public static Integer menuItemLoveFamilyId = 6;
	public static Integer menuItemReadingId = 7;	
	public static Integer menuItemAboutId = 8;
	
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
