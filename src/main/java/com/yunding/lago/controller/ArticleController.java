package com.yunding.lago.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yunding.lago.service.ArticleService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ArticleController extends BaseController {
		
	private ArticleService articleService=null;
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/article/{articleCategory}", method = RequestMethod.GET)
	public String articlesByCatetory(Locale locale, Model model, @PathVariable String articleCategory) {
		logger.info("The client locale is  {}, articleCategory is {}.", locale, articleCategory);
		
		model.addAttribute("articleList", this.articleService.queryArticlesByCategory(articleCategory));
		
		return "article";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/article", method = RequestMethod.GET)
	public String adminArticleList(Locale locale, Model model) {
		logger.info("The client locale is {}.", locale);
		
		model.addAttribute("articleList", this.articleService.queryAllArticles());
		
		return "admin/articleList";
	}
}
