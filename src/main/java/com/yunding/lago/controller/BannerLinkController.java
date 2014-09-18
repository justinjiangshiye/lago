package com.yunding.lago.controller;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yunding.lago.bean.ArticleWithBLOBs;
import com.yunding.lago.bean.BannerLink;
import com.yunding.lago.bean.BulletinBoard;
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
	public String adminBannerLinkAdd(Locale locale, Model model, BannerLink bannerLink) {
		logger.info("Welcome admin index! The client locale is {}.", locale);
		adminInitialize(model, MyConstants.adminMenuItemBannerLinkId);

		return "admin/bannerAdd";
	}
	
	@RequestMapping(value = "/admin/bannerEdit/{bannerLinkId}", method = RequestMethod.GET)
	public String adminbulletinBannerLinkEdit(Locale locale, Model model,
			@PathVariable Integer bannerLinkId) {
		logger.info("The client locale is {}.", locale);
		adminInitialize(model, MyConstants.adminMenuItemBannerLinkId);

		BannerLink bannerLink = this.bannerLinkService.queryBannerLinkById(bannerLinkId);
		
		model.addAttribute("bannerLink", bannerLink);

		logger.info("bulletinBoard Id is {}", bannerLink.getId());
		logger.info("bulletinBoard Text is {}.", bannerLink.getText());
		logger.info("bulletinBoard Bannerurl is {}.", bannerLink.getBannerurl());
		logger.info("bulletinBoard Contenturl is {}.", bannerLink.getContenturl());
		logger.info("bulletinBoard Order is {}.", bannerLink.getOrder());

		return "admin/bannerEdit";
	}

	@RequestMapping(value = "/admin/bannerSave", method = RequestMethod.POST)
	public String adminbannerLinkSave(Locale locale, Model model,
			BannerLink bannerLink) {
		logger.info("The client locale is {}.", locale);
		adminInitialize(model, MyConstants.adminMenuItemBannerLinkId);

		logger.info("bulletinBoard Id is {}", bannerLink.getId());
		logger.info("bulletinBoard Text is {}.", bannerLink.getText());
		logger.info("bulletinBoard Bannerurl is {}.", bannerLink.getBannerurl());
		logger.info("bulletinBoard Contenturl is {}.", bannerLink.getContenturl());
		logger.info("bulletinBoard Order is {}.", bannerLink.getOrder());

		Date now = new Date();
		bannerLink.setRecordstatus(0);

		if (bannerLink.getId() == null) {
			bannerLink.setOrder(this.bannerLinkService.queryCount() + 1);
			bannerLink.setCreatedon(now);
			this.bannerLinkService.addBannerLink(bannerLink);
		} else {
			BannerLink bannerLinkDB = this.bannerLinkService
					.queryBannerLinkById(bannerLink.getId());
			bannerLinkDB.setText(bannerLink.getText());
			bannerLinkDB.setBannerurl(bannerLink.getBannerurl());
			bannerLinkDB.setContenturl(bannerLink.getContenturl());
			this.bannerLinkService.updateBannerLink(bannerLinkDB);
		}

		return "redirect:/admin/banner";
	}

	@RequestMapping(value = "/admin/bannerDelete/{bannerLinkId}", method = RequestMethod.POST)
	public String adminbannerLinkDelete(Locale locale, Model model,
			@PathVariable Integer bannerLinkId) {
		logger.info("The client locale is {}.", locale);
		logger.info("bannerLink Id is {}", bannerLinkId);

		this.bannerLinkService.deleteBannerLinkByPrimaryKey(bannerLinkId);

		return "redirect:/admin/banner";
	}
	
	@RequestMapping(value = "/admin/bannerMoveUp/{bannerLinkId}", method = RequestMethod.POST)
	public String adminBannerLinkMoveUp(Locale locale, Model model,
			@PathVariable Integer bannerLinkId) {
		logger.info("The client locale is {}.", locale);
		logger.info("BannerLink Id is {}", bannerLinkId);

		this.bannerLinkService.updateMoveUp(bannerLinkId);

		return "redirect:/admin/banner";
	}
	
	@RequestMapping(value = "/admin/bannerMoveDown/{bannerLinkId}", method = RequestMethod.POST)
	public String adminBannerLinkMoveDown(Locale locale, Model model,
			@PathVariable Integer bannerLinkId) {
		logger.info("The client locale is {}.", locale);
		logger.info("BannerLink Id is {}", bannerLinkId);

		this.bannerLinkService.updateMoveDown(bannerLinkId);

		return "redirect:/admin/banner";
	}
}
