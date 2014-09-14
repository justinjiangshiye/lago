/**
 * 
 */
package com.yunding.lago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunding.lago.dao.*;
import com.yunding.lago.bean.*;

/**
 * @author justin
 *
 */
@Service
public class ArticleReadStatService {
	private ArticleReadStatMapper articleReadStatMapper;
	@Autowired
	public void setArticleReadStatMapper(ArticleReadStatMapper articleReadStatMapper){
		this.articleReadStatMapper = articleReadStatMapper;
	}
	
	public int queryArticleReadingTimes(Integer articleid) {
		return this.articleReadStatMapper.selectReadingTimes(articleid);
	}
	
	public List<ArticleReadStat> queryArticleReadingHistory(ArticleReadStat articleReadStat) {
		return this.articleReadStatMapper.selectReadingHistory(articleReadStat);
	}
	
	public ArticleReadStat queryArticleReadStatId(Integer id){
		return this.articleReadStatMapper.selectByPrimaryKey(id);
	}
	
	public int addArticleReadStat(ArticleReadStat ArticleReadStat) {
		return this.articleReadStatMapper.insertSelective(ArticleReadStat);
	}
}
