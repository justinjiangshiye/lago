package com.yunding.lago.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yunding.lago.service.BulletinBoardService;
import com.yunding.lago.util.MyConstants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BulletinBoardController extends BaseController {
	private BulletinBoardService bulletinBoardService = null;
	
	@Autowired
	public void setBulletinBoardService(BulletinBoardService bulletinBoardService) {
		this.bulletinBoardService = bulletinBoardService;
	}

	@RequestMapping(value = "/admin/bulletinBoard", method = RequestMethod.GET)
	public String adminBulletinBoard(Locale locale, Model model) {
		logger.info("Welcome about! The client locale is {}.", locale);
		adminInitialize(model, MyConstants.adminMenuItemBulletinBoardId);
		
		model.addAttribute("bulletinBoardList", this.bulletinBoardService.queryAllBulletinBoards());
		
		return "/admin/bulletinBoards";
	}
}
