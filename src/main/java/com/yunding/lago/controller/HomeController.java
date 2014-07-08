package com.yunding.lago.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yunding.lago.service.*;
import com.yunding.lago.bean.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private UserService userService=null;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		User user = this.userService.getUserById(1);
		
		if (user == null) {
			model.addAttribute("userNickName", "NULL");
		}
		else {
			model.addAttribute("userNickName", user.getNickname());
		}
		
		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Locale locale, Model model) {
		logger.info("Welcome about! The client locale is {}.", locale);
		
		return "about";
	}
}
