package com.yunding.lago.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yunding.lago.service.StaticPageService;
import com.yunding.lago.util.MyConstants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class StaticPageController extends BaseController {
	private StaticPageService staticPageService = null;
	
	@Autowired
	public void setStaticPageService(StaticPageService staticPageService) {
		this.staticPageService = staticPageService;
	}
	
	@RequestMapping(value = "/51lago", method = RequestMethod.GET)
	public String lago(Locale locale, Model model) {
		logger.info("Welcome about! The client locale is {}.", locale);
		initialize(model, MyConstants.menuItem51Lago);
		
		model.addAttribute("staticPage", this.staticPageService.queryStaticPageByCategory(MyConstants.category51lago));
		
		return "staticPage";
	}

	@RequestMapping(value = "/51tingting", method = RequestMethod.GET)
	public String tingting(Locale locale, Model model) {
		logger.info("Welcome about! The client locale is {}.", locale);
		initialize(model, MyConstants.menuItem51TingTing);
		
		model.addAttribute("staticPage", this.staticPageService.queryStaticPageByCategory(MyConstants.category51tingting));
		
		return "staticPage";
	}
	
	@RequestMapping(value = "/staticPage/{category}", method = RequestMethod.GET)
	public String staticPage(Locale locale, Model model,
			@PathVariable String category) {
		logger.info("Welcome about! The client locale is {}.", locale);
		
		model.addAttribute("staticPage", this.staticPageService.queryStaticPageByCategory(category));
		
		return "staticPartialPage";
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Locale locale, Model model) {
		logger.info("Welcome about! The client locale is {}.", locale);
		initialize(model, MyConstants.menuItemAboutId);
		
		return "about";
	}
	
	@RequestMapping(value = "/admin/staticPage", method = RequestMethod.GET)
	public String adminStaticPageList(Locale locale, Model model) {
		logger.info("Welcome about! The client locale is {}.", locale);
		adminInitialize(model, MyConstants.adminMenuItemStaticPageId);
		
		return "admin/staticPages";
	}
}
