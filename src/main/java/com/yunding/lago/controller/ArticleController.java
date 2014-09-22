package com.yunding.lago.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunding.lago.bean.ArticleReadStat;
import com.yunding.lago.bean.ArticleWithBLOBs;
import com.yunding.lago.bean.CommentWithReply;
import com.yunding.lago.service.ArticleReadStatService;
import com.yunding.lago.service.ArticleService;
import com.yunding.lago.service.CommentService;
import com.yunding.lago.util.HttpHelper;
import com.yunding.lago.util.MyConstants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ArticleController extends BaseController {

	private CommentService commentService = null;
	private ArticleReadStatService articleReadStatService = null;

	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@Autowired
	public void setArticleReadStatService(
			ArticleReadStatService articleReadStatService) {
		this.articleReadStatService = articleReadStatService;
	}

	@RequestMapping(value = "/admin/verifyArticleSlugsUrl", method = RequestMethod.GET)
	public @ResponseBody
	Boolean verifySlugsUrl(Locale locale, Model model,
			@RequestParam String Slugsurl) {
		ArticleWithBLOBs article = this.articleService
				.queryArticleBySlugsUrl(Slugsurl);
		Boolean result = true;
		if (article != null) {
			result = false;
		}
		return result;
	}

	@RequestMapping(value = "/category/{articleCategorySlugsUrl}", method = RequestMethod.GET)
	public String articlesByCatetorySlugsUrl(Locale locale, Model model,
			@PathVariable String articleCategorySlugsUrl) {
		logger.info("The client locale is  {}, articleCategory is {}.", locale,
				articleCategorySlugsUrl);
		initialize(model,
				MyConstants.getMenuItemIdFromSlugsUrl(articleCategorySlugsUrl));

		model.addAttribute("articleList", this.articleService
				.queryArticlesByCategorySlugsUrl(articleCategorySlugsUrl));

		return "articlesByCategory";
	}

	@RequestMapping(value = "/article/hotreading", method = RequestMethod.GET)
	public String articlesHotReading(Locale locale, Model model) {
		initialize(model, MyConstants.menuItemHotArticleId);

		model.addAttribute("articleList",
				this.articleService.queryTop50HotReadArticles());

		return "articlesByCategory";
	}

	@RequestMapping(value = "/article/{slugsUrl}", method = RequestMethod.GET)
	public String articleBySlugsUrl(Locale locale, Model model,
			HttpServletRequest request,
			@RequestHeader("User-Agent") String userAgent,
			@PathVariable String slugsUrl) {
		logger.info("The client locale is  {}, articleCategory is {}.", locale,
				slugsUrl);

		// Get article with blobs
		ArticleWithBLOBs article = this.articleService
				.queryArticleBySlugsUrl(slugsUrl);
		Integer activeMenuItemId = MyConstants.menuItemHomeId;
		if (article != null) {
			activeMenuItemId = MyConstants
					.getMenuItemIdFromCategoryName(article.getCategory());
		}

		initialize(model, activeMenuItemId);

		model.addAttribute("article", article);

		// Get article comments
		if (article != null) {
			List<CommentWithReply> list = this.commentService
					.queryCommentWithReplyByArticleId(article.getId());
			if (list.size() > 0) {
				model.addAttribute("hasComments", true);
				model.addAttribute("commentList", list);
				model.addAttribute("articleCommentsCount", list.size());
			} else {
				model.addAttribute("hasComments", false);
				model.addAttribute("articleCommentsCount", 0);
			}
		} else {
			model.addAttribute("hasComments", false);
			model.addAttribute("articleCommentsCount", 0);
		}

		// Get article read times
		int readTime = this.articleReadStatService
				.queryArticleReadingTimes(article.getId());
		model.addAttribute("articleReadTime", readTime);

		ArticleReadStat articleReadStat = new ArticleReadStat();
		articleReadStat.setArticleid(article.getId());
		articleReadStat.setSessionid(this.getHttpSession().getId());
		if (this.getHttpSession().getAttribute(
				MyConstants.userLoginIdSessionKey) != null) {
			articleReadStat
					.setUserloginid(this.getHttpSession()
							.getAttribute(MyConstants.userLoginIdSessionKey)
							.toString());
		}
		articleReadStat.setIp(HttpHelper.extractRemoteIP(request));
		articleReadStat.setCreatedon(new Date());
		articleReadStat.setRecordstatus(0);

		List<ArticleReadStat> currentUserReadHistoryList = this.articleReadStatService
				.queryArticleReadingHistory(articleReadStat);
		if (currentUserReadHistoryList == null
				|| currentUserReadHistoryList.size() == 0) {
			// 如果此用户之前没有阅读过，则记录下此次阅读
			this.articleReadStatService.addArticleReadStat(articleReadStat);
		}

		if (userAgent.toLowerCase().indexOf("micromessenger") > 0) {
			return "weixinarticle";
		} else {
			return "article";
		}
	}

	@RequestMapping(value = "/admin/category/{articleCategorySlugsUrl}", method = RequestMethod.GET)
	public String adminArticleList(Locale locale, Model model,
			@PathVariable String articleCategorySlugsUrl) {
		logger.info("The client locale is {}.", locale);
		adminInitialize(
				model,
				MyConstants
						.getAdminMenuItemIdFromSlugsUrl(articleCategorySlugsUrl));

		model.addAttribute("articleCategorySlugsUrl", articleCategorySlugsUrl);
		model.addAttribute("articleCategoryName",
				MyConstants.getNameFromSlugsUrl(articleCategorySlugsUrl));
		model.addAttribute(
				"articleList",
				this.articleService
						.queryArticlesByCategorySlugsUrlForAdmin(articleCategorySlugsUrl));

		return "admin/articles";
	}

	@RequestMapping(value = "/admin/articleAdd/{articleCategorySlugsUrl}", method = RequestMethod.GET)
	public String adminArticleAdd(Locale locale, Model model,
			@PathVariable String articleCategorySlugsUrl) {
		logger.info("The client locale is {}.", locale);
		adminInitialize(
				model,
				MyConstants
						.getAdminMenuItemIdFromSlugsUrl(articleCategorySlugsUrl));

		// Load article edit page
		model.addAttribute("category",
				MyConstants.getNameFromSlugsUrl(articleCategorySlugsUrl));
		model.addAttribute("articleCategorySlugsUrl", articleCategorySlugsUrl);

		return "admin/articleAdd";
	}

	@RequestMapping(value = "/admin/articleEdit/{articleId}", method = RequestMethod.GET)
	public String adminArticleEdit(Locale locale, Model model,
			@PathVariable Integer articleId) {
		logger.info("The client locale is {}.", locale);

		ArticleWithBLOBs articleWithBLOBs = this.articleService
				.queryArticleById(articleId);
		adminInitialize(model,
				MyConstants.getAdminMenuItemIdFromCategoryName(articleWithBLOBs
						.getCategory()));

		model.addAttribute("article", articleWithBLOBs);
		model.addAttribute("articleCategorySlugsUrl",
				MyConstants.getSlugsUrlFromName(articleWithBLOBs.getCategory()));

		logger.info("Article Id is {}", articleWithBLOBs.getId());
		logger.info("Article Category is {}.", articleWithBLOBs.getCategory());
		logger.info("Article Title is {}.", articleWithBLOBs.getTitle());
		logger.info("Article SlugsUrl is {}.", articleWithBLOBs.getSlugsurl());
		logger.info("Article AbstractContent is {}.",
				articleWithBLOBs.getAbstractcontent());
		logger.info("Article BannerUrl is {}.", articleWithBLOBs.getBannerurl());
		logger.info("Article IsDisplayOnHome is {}.",
				articleWithBLOBs.getIsdisplayonhome());
		logger.info("Article IsLockTop is {}.", articleWithBLOBs.getIslocktop());
		logger.info("Article IsPublished is {}.",
				articleWithBLOBs.getIspublished());
		logger.info("Article Keywords is {}.", articleWithBLOBs.getKeywords());
		logger.info("Article Content is {}.", articleWithBLOBs.getContent());

		return "admin/articleEdit";
	}

	@RequestMapping(value = "/admin/articleSave", method = RequestMethod.POST)
	public String adminArticleSave(Locale locale, Model model,
			ArticleWithBLOBs articleWithBLOBs) {
		logger.info("The client locale is {}.", locale);
		logger.info("Article Id is {}", articleWithBLOBs.getId());
		logger.info("Article Category is {}.", articleWithBLOBs.getCategory());
		logger.info("Article Title is {}.", articleWithBLOBs.getTitle());
		logger.info("Article SlugsUrl is {}.", articleWithBLOBs.getSlugsurl());
		logger.info("Article AbstractContent is {}.",
				articleWithBLOBs.getAbstractcontent());
		logger.info("Article BannerUrl is {}.", articleWithBLOBs.getBannerurl());
		logger.info("Article IsDisplayOnHome is {}.",
				articleWithBLOBs.getIsdisplayonhome());
		logger.info("Article IsLockTop is {}.", articleWithBLOBs.getIslocktop());
		logger.info("Article IsPublished is {}.",
				articleWithBLOBs.getIspublished());
		logger.info("Article Keywords is {}.", articleWithBLOBs.getKeywords());
		logger.info("Article Content is {}.", articleWithBLOBs.getContent());
		adminInitialize(model,
				MyConstants.getAdminMenuItemIdFromCategoryName(articleWithBLOBs
						.getCategory()));

		if (articleWithBLOBs.getIsdisplayonhome() == null) {
			articleWithBLOBs.setIsdisplayonhome(false);
		}
		if (articleWithBLOBs.getIslocktop() == null) {
			articleWithBLOBs.setIslocktop(false);
		}
		if (articleWithBLOBs.getIspublished() == null) {
			articleWithBLOBs.setIspublished(false);
		}
		Date now = new Date();
		if (articleWithBLOBs.getIspublished()) {
			articleWithBLOBs.setPublishdate(now);
		}
		articleWithBLOBs.setRecordstatus(0);

		if (articleWithBLOBs.getId() == null) {
			articleWithBLOBs.setOrder(this.articleService
					.queryCountByCategory(articleWithBLOBs.getCategory()) + 1);
			articleWithBLOBs.setCreatedon(now);
			this.articleService.addArticle(articleWithBLOBs);
		} else {
			ArticleWithBLOBs articleWithBLOBsDB = this.articleService
					.queryArticleById(articleWithBLOBs.getId());
			articleWithBLOBsDB.setCategory(articleWithBLOBs.getCategory());
			articleWithBLOBsDB.setTitle(articleWithBLOBs.getTitle());
			articleWithBLOBsDB.setSlugsurl(articleWithBLOBs.getSlugsurl());
			articleWithBLOBsDB.setAbstractcontent(articleWithBLOBs
					.getAbstractcontent());
			articleWithBLOBsDB.setBannerurl(articleWithBLOBs.getBannerurl());
			articleWithBLOBsDB.setIsdisplayonhome(articleWithBLOBs
					.getIsdisplayonhome());
			articleWithBLOBsDB.setIslocktop(articleWithBLOBs.getIslocktop());
			articleWithBLOBsDB
					.setIspublished(articleWithBLOBs.getIspublished());
			articleWithBLOBsDB
					.setPublishdate(articleWithBLOBs.getPublishdate());
			articleWithBLOBsDB.setKeywords(articleWithBLOBs.getKeywords());
			articleWithBLOBsDB.setContent(articleWithBLOBs.getContent());
			this.articleService.updateArticle(articleWithBLOBsDB);
		}

		return "redirect:/admin/category/"
				+ MyConstants.getSlugsUrlFromName(articleWithBLOBs
						.getCategory());
	}

	@RequestMapping(value = "/admin/articleDelete/{articleId}", method = RequestMethod.POST)
	public String adminArticleDelete(Locale locale, Model model,
			@PathVariable Integer articleId) {
		logger.info("The client locale is {}.", locale);
		logger.info("Article Id is {}", articleId);

		ArticleWithBLOBs articleWithBLOBs = this.articleService
				.queryArticleById(articleId);

		this.articleService.deleteArticleByPrimaryKey(articleId);

		return "redirect:/admin/category/"
				+ MyConstants.getSlugsUrlFromName(articleWithBLOBs
						.getCategory());
	}

	@RequestMapping(value = "/admin/articleMoveUp/{articleId}", method = RequestMethod.POST)
	public String adminArticleMoveUp(Locale locale, Model model,
			@PathVariable Integer articleId) {
		logger.info("The client locale is {}.", locale);
		logger.info("Article Id is {}", articleId);

		ArticleWithBLOBs articleWithBLOBs = this.articleService
				.queryArticleById(articleId);

		this.articleService.updateMoveUp(articleId);

		return "redirect:/admin/category/"
				+ MyConstants.getSlugsUrlFromName(articleWithBLOBs
						.getCategory());
	}

	@RequestMapping(value = "/admin/articleMoveDown/{articleId}", method = RequestMethod.POST)
	public String adminArticleMoveDown(Locale locale, Model model,
			@PathVariable Integer articleId) {
		logger.info("The client locale is {}.", locale);
		logger.info("Article Id is {}", articleId);

		ArticleWithBLOBs articleWithBLOBs = this.articleService
				.queryArticleById(articleId);

		this.articleService.updateMoveDown(articleId);

		return "redirect:/admin/category/"
				+ MyConstants.getSlugsUrlFromName(articleWithBLOBs
						.getCategory());
	}
}
