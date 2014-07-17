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
	@RequestMapping(value = "/articles/{articleCategory}", method = RequestMethod.GET)
	public String articlesByCatetory(Locale locale, Model model, @PathVariable String articleCategory) {
		logger.info("The client locale is  {}, articleCategory is {}.", locale, articleCategory);
		
		model.addAttribute("articleList", this.articleService.queryArticlesByCategory(articleCategory));
		
		return "articles";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/article/{slugsUrl}", method = RequestMethod.GET)
	public String articleBySlugsUrl(Locale locale, Model model, @PathVariable String slugsUrl) {
		logger.info("The client locale is  {}, articleCategory is {}.", locale, slugsUrl);
		
		model.addAttribute("articleList", this.articleService.queryArticlesByCategory(slugsUrl));
		
		return "article";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/articles", method = RequestMethod.GET)
	public String adminArticleList(Locale locale, Model model) {
		logger.info("The client locale is {}.", locale);
		
		model.addAttribute("articleList", this.articleService.queryAllArticles());
		
		return "admin/articles";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/articleAdd", method = RequestMethod.GET)
	public String adminArticleAdd(Locale locale, Model model) {
		logger.info("The client locale is {}.", locale);
		
		//model.addAttribute("articleList", this.articleService.queryAllArticles());
		
		return "admin/articleAdd";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/articleAdd", method = RequestMethod.POST)
	public String adminArticleSave(Locale locale, Model model) {
		logger.info("The client locale is {}.", locale);
		
		//model.addAttribute("articleList", this.articleService.queryAllArticles());
		
		return "admin/articles";
	}
}
