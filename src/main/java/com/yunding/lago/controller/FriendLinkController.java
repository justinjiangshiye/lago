package com.yunding.lago.controller;

import java.util.Date;
import java.util.Locale;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yunding.lago.bean.Article;
import com.yunding.lago.bean.ArticleWithBLOBs;
import com.yunding.lago.bean.FriendLinkWithBLOBs;
import com.yunding.lago.bean.MyConstants;
import com.yunding.lago.service.ArticleService;
import com.yunding.lago.service.FriendLinkService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FriendLinkController extends BaseController {

	private FriendLinkService friendLinkService = null;

	@Autowired
	public void setFriendLinkService(FriendLinkService friendLinkService) {
		this.friendLinkService = friendLinkService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/friendLinks", method = RequestMethod.GET)
	public String adminArticleList(Locale locale, Model model) {
		logger.info("The client locale is {}.", locale);

		model.addAttribute("friendLinkList",
				this.friendLinkService.queryAllFriendLinks());

		return "admin/friendLinks";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/friendLinkAdd", method = RequestMethod.GET)
	public String adminArticleAdd(Locale locale, Model model) {
		logger.info("The client locale is {}.", locale);

		// Load article edit page

		return "admin/friendLinkAdd";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/friendLinkEdit/{friendLinkId}", method = RequestMethod.GET)
	public String adminArticleEdit(Locale locale, Model model,
			@PathVariable Integer friendLinkId) {
		logger.info("The client locale is {}.", locale);

		FriendLinkWithBLOBs friendLinkWithBLOBs = this.friendLinkService
				.queryFriendLinkById(friendLinkId);
		model.addAttribute("friendLink", friendLinkWithBLOBs);

		logger.info("Article Id is {}", friendLinkWithBLOBs.getId());

		return "admin/friendLinkEdit";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/friendLinkSave", method = RequestMethod.POST)
	public String adminArticleSave(Locale locale, Model model,
			FriendLinkWithBLOBs friendLinkWithBLOBs) {
		logger.info("The client locale is {}.", locale);
		logger.info("Article Id is {}", friendLinkWithBLOBs.getId());

		Date now = new Date();
		friendLinkWithBLOBs.setRecordstatus(0);

		if (friendLinkWithBLOBs.getId() == null) {
			friendLinkWithBLOBs.setCreatedon(now);
			this.friendLinkService.addFriendLink(friendLinkWithBLOBs);
		} else {
			FriendLinkWithBLOBs friendLinkWithBLOBsDB = this.friendLinkService.queryFriendLinkById(friendLinkWithBLOBs.getId());
			friendLinkWithBLOBsDB.setWebsitename(friendLinkWithBLOBs.getWebsitename());
			friendLinkWithBLOBsDB.setWebsiteurl(friendLinkWithBLOBs.getWebsiteurl());
			friendLinkWithBLOBsDB.setLogourl(friendLinkWithBLOBs.getLogourl());
			this.friendLinkService.updateFriendLink(friendLinkWithBLOBsDB);
		}

		return "redirect:/admin/friendLinks";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/friendLinkDelete/{friendLinkId}", method = RequestMethod.GET)
	public String adminArticleDelete(Locale locale, Model model,
			@PathVariable Integer friendLinkId) {
		logger.info("The client locale is {}.", locale);
		
		logger.info("Article Id is {}", friendLinkId);

		FriendLinkWithBLOBs friendLinkWithBLOBs = this.friendLinkService
				.queryFriendLinkById(friendLinkId);		
		friendLinkWithBLOBs.setRecordstatus(2);
		this.friendLinkService.updateFriendLink(friendLinkWithBLOBs);

		return "redirect:/admin/friendLinks";
	}
}
