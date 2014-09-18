package com.yunding.lago.controller;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yunding.lago.bean.BulletinBoard;
import com.yunding.lago.service.BulletinBoardService;
import com.yunding.lago.util.MyConstants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BulletinBoardController extends BaseController {	
	@Autowired
	public void setBulletinBoardService(BulletinBoardService bulletinBoardService) {
		this.bulletinBoardService = bulletinBoardService;
	}
	
	@RequestMapping(value = "/bulletinBoard/{bulletinBoardId}", method = RequestMethod.GET)
	public String bulletinBoard(Locale locale, Model model,
			@PathVariable Integer bulletinBoardId) {
		logger.info("The client locale is {}.", locale);
		initialize(model, MyConstants.menuItemBulletinBoardId);

		BulletinBoard bulletinBoard = this.bulletinBoardService
				.queryBulletinBoardById(bulletinBoardId);
		
		model.addAttribute("bulletinBoard", bulletinBoard);

		logger.info("bulletinBoard Id is {}", bulletinBoard.getId());
		logger.info("bulletinBoard Summary is {}.", bulletinBoard.getSummary());
		logger.info("bulletinBoard Content is {}.", bulletinBoard.getContent());
		logger.info("bulletinBoard IsPublished is {}.", bulletinBoard.getIspublished());
		logger.info("bulletinBoard Order is {}.", bulletinBoard.getOrder());;

		return "bulletinBoard";
	}

	@RequestMapping(value = "/admin/bulletinBoards", method = RequestMethod.GET)
	public String adminBulletinBoardList(Locale locale, Model model) {
		logger.info("Welcome about! The client locale is {}.", locale);
		adminInitialize(model, MyConstants.adminMenuItemBulletinBoardId);
		
		model.addAttribute("bulletinBoardList", this.bulletinBoardService.queryAllBulletinBoards());
		
		return "admin/bulletinBoards";
	}

	@RequestMapping(value = "/admin/bulletinBoardAdd", method = RequestMethod.GET)
	public String adminBulletinBoardAdd(Locale locale, Model model) {
		logger.info("Welcome about! The client locale is {}.", locale);
		adminInitialize(model, MyConstants.adminMenuItemBulletinBoardId);
				
		return "admin/bulletinBoardAdd";
	}

	@RequestMapping(value = "/admin/bulletinBoardEdit/{bulletinBoardId}", method = RequestMethod.GET)
	public String adminbulletinBoardEdit(Locale locale, Model model,
			@PathVariable Integer bulletinBoardId) {
		logger.info("The client locale is {}.", locale);
		adminInitialize(model, MyConstants.adminMenuItemBulletinBoardId);

		BulletinBoard bulletinBoard = this.bulletinBoardService
				.queryBulletinBoardById(bulletinBoardId);
		
		model.addAttribute("bulletinBoard", bulletinBoard);

		logger.info("bulletinBoard Id is {}", bulletinBoard.getId());
		logger.info("bulletinBoard Summary is {}.", bulletinBoard.getSummary());
		logger.info("bulletinBoard Content is {}.", bulletinBoard.getContent());
		logger.info("bulletinBoard IsPublished is {}.", bulletinBoard.getIspublished());
		logger.info("bulletinBoard Order is {}.", bulletinBoard.getOrder());;

		return "admin/bulletinBoardEdit";
	}

	@RequestMapping(value = "/admin/bulletinBoardSave", method = RequestMethod.POST)
	public String adminbulletinBoardSave(Locale locale, Model model,
			BulletinBoard bulletinBoard) {
		logger.info("The client locale is {}.", locale);
		adminInitialize(model, MyConstants.adminMenuItemBulletinBoardId);
		
		logger.info("bulletinBoard Id is {}", bulletinBoard.getId());
		logger.info("bulletinBoard Summary is {}.", bulletinBoard.getSummary());
		logger.info("bulletinBoard Content is {}.", bulletinBoard.getContent());
		logger.info("bulletinBoard IsPublished is {}.", bulletinBoard.getIspublished());
		logger.info("bulletinBoard Order is {}.", bulletinBoard.getOrder());;

		if (bulletinBoard.getIspublished() == null) {
			bulletinBoard.setIspublished(false);
		}
		Date now = new Date();
		if (bulletinBoard.getIspublished()) {
			bulletinBoard.setPublishdate(now);
		}
		bulletinBoard.setRecordstatus(0);

		if (bulletinBoard.getId() == null) {
			bulletinBoard.setCreatedon(now);
			bulletinBoard.setOrder(this.bulletinBoardService.queryCount() + 1);
			this.bulletinBoardService.addBulletinBoard(bulletinBoard);
		} else {
			BulletinBoard bulletinBoardDB = this.bulletinBoardService
					.queryBulletinBoardById(bulletinBoard.getId());
			bulletinBoardDB.setSummary(bulletinBoard.getSummary());
			bulletinBoardDB.setContent(bulletinBoard.getContent());
			bulletinBoardDB.setIspublished(bulletinBoard.getIspublished());
			bulletinBoardDB.setPublishdate(bulletinBoard.getPublishdate());
			this.bulletinBoardService.updateBulletinBoard(bulletinBoardDB);
		}

		return "redirect:/admin/bulletinBoards";
	}

	@RequestMapping(value = "/admin/bulletinBoardDelete/{bulletinBoardId}", method = RequestMethod.POST)
	public String adminbulletinBoardDelete(Locale locale, Model model,
			@PathVariable Integer bulletinBoardId) {
		logger.info("The client locale is {}.", locale);
		logger.info("BulletinBoard Id is {}", bulletinBoardId);

		this.bulletinBoardService.deleteBulletinBoardByPrimaryKey(bulletinBoardId);

		return "redirect:/admin/bulletinBoards";
	}
	
	@RequestMapping(value = "/admin/bulletinBoardMoveUp/{bulletinBoardId}", method = RequestMethod.POST)
	public String adminBulletinBoardMoveUp(Locale locale, Model model,
			@PathVariable Integer bulletinBoardId) {
		logger.info("The client locale is {}.", locale);
		logger.info("BulletinBoard Id is {}", bulletinBoardId);

		this.bulletinBoardService.updateMoveUp(bulletinBoardId);

		return "redirect:/admin/bulletinBoards";
	}
	
	@RequestMapping(value = "/admin/bulletinBoardMoveDown/{bulletinBoardId}", method = RequestMethod.POST)
	public String adminBulletinBoardMoveDown(Locale locale, Model model,
			@PathVariable Integer bulletinBoardId) {
		logger.info("The client locale is {}.", locale);
		logger.info("BulletinBoard Id is {}", bulletinBoardId);

		this.bulletinBoardService.updateMoveDown(bulletinBoardId);

		return "redirect:/admin/bulletinBoards";
	}
}
