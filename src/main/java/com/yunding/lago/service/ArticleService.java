package com.yunding.lago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yunding.lago.bean.*;
import com.yunding.lago.dao.*;

public class ArticleService {
	private ArticleMapper articleMapper = null;
	@Autowired
	public void setArticleMapper(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
	}
	
	public List<Article> queryHomePageArticles() throws Exception {
		throw new Exception("queryHomePageArticles not implemented.");
	}
}
