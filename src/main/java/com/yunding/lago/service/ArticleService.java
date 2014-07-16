package com.yunding.lago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunding.lago.bean.Article;
import com.yunding.lago.bean.ArticleWithBLOBs;
import com.yunding.lago.dao.ArticleMapper;

@Service
public class ArticleService {
	private ArticleMapper articleMapper = null;
	@Autowired
	public void setArticleMapper(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
	}
	
	public ArticleWithBLOBs queryArticleById(Integer id) {
		return this.articleMapper.selectByPrimaryKey(id);
	}
	
	public List<Article> queryAllArticles() {
		return this.articleMapper.selectAllArticles();
	}
	
	public List<Article> queryHomePageArticles(String category) {
		return this.articleMapper.selectHomePageArticles(category);
	}
	
	public List<Article> queryArticlesByCategory(String category) {
		return this.articleMapper.selectArticlesByCategory(category);
	}
	
	public int addArticle(ArticleWithBLOBs articleWithBLOBs) {
		return this.articleMapper.insertSelective(articleWithBLOBs);
	}
	
	public int updateArticle(ArticleWithBLOBs articleWithBLOBs) {
		return this.articleMapper.updateByPrimaryKeyWithBLOBs(articleWithBLOBs);
	}
}