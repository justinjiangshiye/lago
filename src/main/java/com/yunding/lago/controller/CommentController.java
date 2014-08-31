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
import com.yunding.lago.service.ArticleService;
import com.yunding.lago.service.CommentService;
import com.yunding.lago.util.MyConstants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommentController extends BaseController {

	private ArticleService articleService = null;
	private CommentService commentService = null;

	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@RequestMapping(value = "/article/commentSave", method = RequestMethod.POST)
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

		Date now = new Date();
		if (articleWithBLOBs.getIspublished()) {
			articleWithBLOBs.setPublishdate(now);
		}
		articleWithBLOBs.setRecordstatus(0);

		if (articleWithBLOBs.getId() == null) {
			articleWithBLOBs.setCreatedon(now);
			this.articleService.addArticle(articleWithBLOBs);
		} else {
			ArticleWithBLOBs articleWithBLOBsDB = this.articleService.queryArticleById(articleWithBLOBs.getId());
			articleWithBLOBsDB.setCategory(articleWithBLOBs.getCategory());
			articleWithBLOBsDB.setTitle(articleWithBLOBs.getTitle());
			articleWithBLOBsDB.setSlugsurl(articleWithBLOBs.getSlugsurl());
			articleWithBLOBsDB.setAbstractcontent(articleWithBLOBs.getAbstractcontent());
			articleWithBLOBsDB.setBannerurl(articleWithBLOBs.getBannerurl());
			articleWithBLOBsDB.setIsdisplayonhome(articleWithBLOBs.getIsdisplayonhome());
			articleWithBLOBsDB.setIslocktop(articleWithBLOBs.getIslocktop());
			articleWithBLOBsDB.setIspublished(articleWithBLOBs.getIspublished());
			articleWithBLOBsDB.setPublishdate(articleWithBLOBs.getPublishdate());
			articleWithBLOBsDB.setKeywords(articleWithBLOBs.getKeywords());
			articleWithBLOBsDB.setContent(articleWithBLOBs.getContent());
			this.articleService.updateArticle(articleWithBLOBsDB);
		}

		return "redirect:/admin/articles";
	}
	
	@RequestMapping(value = "/article/commentDelete/{commentId}", method = RequestMethod.GET)
	public String adminArticleDelete(Locale locale, Model model,
			@PathVariable Integer articleId) {
		logger.info("The client locale is {}.", locale);
		
		logger.info("Article Id is {}", articleId);

		ArticleWithBLOBs articleWithBLOBs = this.articleService
				.queryArticleById(articleId);		
		articleWithBLOBs.setRecordstatus(2);
		this.articleService.updateArticle(articleWithBLOBs);

		return "redirect:/admin/articles";
	}
}
