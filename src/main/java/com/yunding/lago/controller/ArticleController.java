package com.yunding.lago.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yunding.lago.bean.User;
import com.yunding.lago.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ArticleController extends BaseController {
		
	private UserService userService=null;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/article/{articleCategory}", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		User user = this.userService.queryUserById(1);
		
		if (user == null) {
			model.addAttribute("userNickName", "NULL");
		}
		else {
			model.addAttribute("userNickName", user.getNickname());
		}
		
		return "index";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/article", method = RequestMethod.GET)
	public String adminArticleList(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		User user = this.userService.queryUserById(1);
		
		if (user == null) {
			model.addAttribute("userNickName", "NULL");
		}
		else {
			model.addAttribute("userNickName", user.getNickname());
		}
		
		return "admin/articleList";
	}
}
