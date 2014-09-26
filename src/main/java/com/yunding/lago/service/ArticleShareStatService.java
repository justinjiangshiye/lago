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
public class ArticleShareStatService {
	private ArticleShareStatMapper articleShareStatMapper;
	@Autowired
	public void setArticleShareStatMapper(ArticleShareStatMapper articleShareStatMapper){
		this.articleShareStatMapper = articleShareStatMapper;
	}
	
	public ArticleShareStat queryArticleShareStatId(Integer id){
		return this.articleShareStatMapper.selectByPrimaryKey(id);
	}
	
	public int QueryArticleShareTimes(Integer articleId) {
		return this.articleShareStatMapper.selectShareTimes(articleId);
	}
	
	public int queryCount() {
		return this.articleShareStatMapper.selectCount();
	}
	
	public int addArticleShareStat(ArticleShareStat ArticleShareStat) {
		return this.articleShareStatMapper.insertSelective(ArticleShareStat);
	}
}
