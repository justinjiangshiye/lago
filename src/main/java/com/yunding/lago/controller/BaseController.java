package com.yunding.lago.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.yunding.lago.bean.*;
import com.yunding.lago.service.ArticleService;
import com.yunding.lago.service.BulletinBoardService;
import com.yunding.lago.service.FriendLinkService;

/**
 * Base controller
 */
public class BaseController {
	private FriendLinkService friendLinkService = null;
	private BulletinBoardService bulletinBoardService = null;

	@Autowired
	public void setFriendLinkService(FriendLinkService friendLinkService) {
		this.friendLinkService = friendLinkService;
	}

	@Autowired
	public void setBulletinBoardService(BulletinBoardService bulletinBoardService) {
		this.bulletinBoardService = bulletinBoardService;
	}

	protected static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	protected void initialize(Model model, Integer activeMenuItemId) {
		if (activeMenuItemId == null) {
			activeMenuItemId = 1;
		}
		logger.info("The activeMenuItemId is {}", activeMenuItemId);
		model.addAttribute("activeMenuItemId", activeMenuItemId);
		
		//TODO: add menu item list
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		model.addAttribute("menuItemList", menuItems);
		
		// Add bulletin boards
		model.addAttribute("bulletinBoardList", this.bulletinBoardService.queryPublishedBulletinBoards());
		
		// Add friend links
		model.addAttribute("friendLinkList", this.friendLinkService.queryAllFriendLinks());
	}
}
