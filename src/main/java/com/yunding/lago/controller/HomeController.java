package com.yunding.lago.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yunding.lago.service.ArticleService;
import com.yunding.lago.service.BannerLinkService;
import com.yunding.lago.util.MyConstants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends BaseController {
	private ArticleService articleService = null;
	private BannerLinkService bannerLinkService = null;
	
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@Autowired
	public void setBannerLinkService(BannerLinkService bannerLinkService) {
		this.bannerLinkService = bannerLinkService;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		initialize(model, MyConstants.menuItemHomeId);
		
		model.addAttribute("bannerlinkList", this.bannerLinkService.queryAllBannerLinks());
		model.addAttribute("parentschoolList", this.articleService.queryHomePageArticles(MyConstants.parentSchoolName));
		model.addAttribute("growupList", this.articleService.queryHomePageArticles(MyConstants.growUpName));
		model.addAttribute("lovefamilyList", this.articleService.queryHomePageArticles(MyConstants.loveFamilyName));
		model.addAttribute("readingList", this.articleService.queryHomePageArticles(MyConstants.readingName));
		
		return "index";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminIndex(Locale locale, Model model) {
		logger.info("Welcome admin index! The client locale is {}.", locale);
		adminInitialize(model, MyConstants.adminMenuItemHomeId);
		
		return "admin/index";
	}
}
