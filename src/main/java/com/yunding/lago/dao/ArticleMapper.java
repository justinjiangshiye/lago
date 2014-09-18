package com.yunding.lago.dao;

import java.util.List;

import com.yunding.lago.bean.Article;
import com.yunding.lago.bean.ArticleWithBLOBs;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

	int insert(ArticleWithBLOBs record);

	int insertSelective(ArticleWithBLOBs record);

	ArticleWithBLOBs selectByPrimaryKey(Integer id);
	
	ArticleWithBLOBs selectBySlugsUrl(String slugsurl);
	
	List<Article> selectAllArticles();
    
    List<Article> selectHomePageArticles(String category);
    
    List<Article> selectAllArticlesByCategory(String category);
    
    List<Article> selectPublishedArticlesByCategory(String category);
    
    List<Article> selectTop10HotReadArticles();
    
    List<Article> selectTop50HotReadArticles();
    
    int selectCountByCategory(String category);

	int updateByPrimaryKeySelective(ArticleWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

	int updateByPrimaryKey(Article record);
	
	int updateArticleLogicDelete(Integer id);
	
	int updateReorderArticle(Integer id);
	
	int updateMoveUp(Integer id);
	
	int updateMoveDown(Integer id);
}