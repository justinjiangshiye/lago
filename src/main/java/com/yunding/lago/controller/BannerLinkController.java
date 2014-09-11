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
 * Handles requests for the application banner page.
 */
@Controller
public class BannerLinkController extends BaseController {
	private BannerLinkService bannerLinkService = null;
	
	@Autowired
	public void setBannerLinkService(BannerLinkService bannerLinkService) {
		this.bannerLinkService = bannerLinkService;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/banner", method = RequestMethod.GET)
	public String adminBannerLinkList(Locale locale, Model model) {
		logger.info("Welcome admin index! The client locale is {}.", locale);
		adminInitialize(model, MyConstants.adminMenuItemBannerLinkId);
		
		model.addAttribute("bannerLinkList", this.bannerLinkService.queryAllBannerLinks());
		
		return "admin/banners";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/bannerAdd", method = RequestMethod.GET)
	public String adminBannerLinkAdd(Locale locale, Model model) {
		logger.info("Welcome admin index! The client locale is {}.", locale);
		adminInitialize(model, MyConstants.adminMenuItemBannerLinkId);
				
		return "admin/bannerAdd";
	}
}
