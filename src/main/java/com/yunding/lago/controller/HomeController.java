package com.yunding.lago.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunding.lago.bean.VisitLog;
import com.yunding.lago.service.ArticleReadStatService;
import com.yunding.lago.service.ArticleService;
import com.yunding.lago.service.ArticleShareStatService;
import com.yunding.lago.service.BannerLinkService;
import com.yunding.lago.service.CommentService;
import com.yunding.lago.service.VisitLogService;
import com.yunding.lago.util.HttpHelper;
import com.yunding.lago.util.MyConstants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends BaseController {
	private BannerLinkService bannerLinkService = null;
	private VisitLogService visitLogService = null;
	private ArticleReadStatService articleReadStatService = null;
	private ArticleShareStatService articleShareStatService = null;
	private CommentService commentService = null;

	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Autowired
	public void setBannerLinkService(BannerLinkService bannerLinkService) {
		this.bannerLinkService = bannerLinkService;
	}

	@Autowired
	public void setVisitLogService(VisitLogService visitLogService) {
		this.visitLogService = visitLogService;
	}

	@Autowired
	public void setArticleReadStatService(
			ArticleReadStatService articleReadStatService) {
		this.articleReadStatService = articleReadStatService;
	}

	@Autowired
	public void setArticleShareStatService(
			ArticleShareStatService articleShareStatService) {
		this.articleShareStatService = articleShareStatService;
	}

	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		initialize(model, MyConstants.menuItemHomeId);

		model.addAttribute("bannerlinkList",
				this.bannerLinkService.queryAllBannerLinks());
		model.addAttribute("parentschoolList", this.articleService
				.queryHomePageArticles(MyConstants.parentSchoolName));
		model.addAttribute("growupList", this.articleService
				.queryHomePageArticles(MyConstants.growUpName));
		model.addAttribute("lovefamilyList", this.articleService
				.queryHomePageArticles(MyConstants.loveFamilyName));
		model.addAttribute("readingList", this.articleService
				.queryHomePageArticles(MyConstants.readingName));

		return "index";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/visit", method = RequestMethod.GET)
	public @ResponseBody
	String visit(HttpServletRequest request, @RequestParam String uri)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");

		try {
			VisitLog visitLog = new VisitLog();
			visitLog.setUrl(uri);
			visitLog.setSessionid(request.getSession().getId());
			if (request.getSession().getAttribute(
					MyConstants.userLoginIdSessionKey) != null) {
				visitLog.setUserloginid(request.getSession()
						.getAttribute(MyConstants.userLoginIdSessionKey)
						.toString());
			}
			visitLog.setIp(HttpHelper.extractRemoteIP(request));
			visitLog.setCreatedon(new Date());
			visitLog.setRecordstatus(0);
			this.visitLogService.addVisitLog(visitLog);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return "ok";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminIndex(Locale locale, Model model) {
		logger.info("Welcome admin index! The client locale is {}.", locale);
		adminInitialize(model, MyConstants.adminMenuItemHomeId);

		model.addAttribute("visitCount", this.visitLogService.queryCount());
		model.addAttribute("articleReadingCount",
				this.articleReadStatService.queryCount());
		model.addAttribute("articleShareCount",
				this.articleShareStatService.queryCount());
		model.addAttribute("articleCommentsCount",
				this.commentService.queryCount());

		return "admin/index";
	}
}
