package com.yunding.lago.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.yunding.lago.bean.*;

/**
 * Base controller
 */
public class BaseController {
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
		
	}
}
