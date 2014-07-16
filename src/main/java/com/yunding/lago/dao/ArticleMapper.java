package com.yunding.lago.dao;

import java.util.List;

import com.yunding.lago.bean.Article;
import com.yunding.lago.bean.ArticleWithBLOBs;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

	int insert(ArticleWithBLOBs record);

	int insertSelective(ArticleWithBLOBs record);

	ArticleWithBLOBs selectByPrimaryKey(Integer id);
	
	List<Article> selectAllArticles();
    
    List<Article> selectHomePageArticles(String category);
    
    List<Article> selectArticlesByCategory(String category);

	int updateByPrimaryKeySelective(ArticleWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

	int updateByPrimaryKey(Article record);
}