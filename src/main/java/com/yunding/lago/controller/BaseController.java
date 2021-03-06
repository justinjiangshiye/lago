package com.yunding.lago.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.yunding.lago.bean.MenuItem;
import com.yunding.lago.service.AppDownloadService;
import com.yunding.lago.service.ArticleService;
import com.yunding.lago.service.BulletinBoardService;
import com.yunding.lago.service.FriendLinkService;
import com.yunding.lago.service.UserService;
import com.yunding.lago.util.MyConstants;

/**
 * Base controller
 */
public class BaseController {
	protected FriendLinkService friendLinkService = null;
	protected BulletinBoardService bulletinBoardService = null;
	protected UserService userService = null;
	protected HttpSession httpSession = null;
	protected AppDownloadService appDownloadService = null;
	protected ArticleService articleService = null;

	@Autowired
	public void setFriendLinkService(FriendLinkService friendLinkService) {
		this.friendLinkService = friendLinkService;
	}

	@Autowired
	public void setBulletinBoardService(BulletinBoardService bulletinBoardService) {
		this.bulletinBoardService = bulletinBoardService;
	}
	
	@Autowired
	public void setAppDownloadService(AppDownloadService appDownloadService) {
		this.appDownloadService = appDownloadService;
	}
	
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public UserService getUserService() {
		return this.userService;
	}
	
	@Autowired
	public void setHttpSession(HttpSession httpSession) {
		this.httpSession = httpSession;
	}
	
	public HttpSession getHttpSession() {
		return this.httpSession;
	}

	protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	protected void adminInitialize(Model model, Integer activeMenuItemId) {
		// Add user profile info
		if (httpSession.getAttribute(MyConstants.userLoginIdSessionKey) != null) {
			logger.info(httpSession.getAttribute(MyConstants.userLoginIdSessionKey).toString());
			model.addAttribute("currentUser", this.userService.queryUserByLoginId(httpSession.getAttribute(MyConstants.userLoginIdSessionKey).toString()));
		}
		
		// Add active menu item
		if (activeMenuItemId == null) {
			activeMenuItemId = 1;
		}
		logger.info("The activeMenuItemId is {}", activeMenuItemId);
		model.addAttribute("activeMenuItemId", activeMenuItemId);
		
		//TODO: add menu item list
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		model.addAttribute("menuItemList", menuItems);
	}
	
	protected void initialize(Model model, Integer activeMenuItemId) {
		// Add user profile info
		if (httpSession.getAttribute(MyConstants.userLoginIdSessionKey) != null) {
			logger.info(httpSession.getAttribute(MyConstants.userLoginIdSessionKey).toString());
			model.addAttribute("currentUser", this.userService.queryUserByLoginId(httpSession.getAttribute(MyConstants.userLoginIdSessionKey).toString()));
		}
		
		// Add active menu item
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
		
		// Add app downloads
		model.addAttribute("appDownloadList", this.appDownloadService.queryAllAppDownloads());
		
		// Add hotread articles
		model.addAttribute("hotReadArticleList", this.articleService.queryTop10HotReadArticles());
	}
	
	@SuppressWarnings("unchecked")
	protected void addMessage(String msg) {
		if (httpSession.getAttribute(MyConstants.messageListSessionKey) == null) {
			httpSession.setAttribute(MyConstants.messageListSessionKey, new ArrayList<String>()); 
		}
		List<String> list = (ArrayList<String>)httpSession.getAttribute(MyConstants.messageListSessionKey);
		list.add(msg);
	}
}
