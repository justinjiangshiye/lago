package com.yunding.lago.dao;

import com.yunding.lago.bean.ArticleShareStat;

public interface ArticleShareStatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleShareStat record);

    int insertSelective(ArticleShareStat record);

    ArticleShareStat selectByPrimaryKey(Integer id);

    int selectShareTimes(Integer articleid);
    
    int selectCount();
    
    int updateByPrimaryKeySelective(ArticleShareStat record);

    int updateByPrimaryKey(ArticleShareStat record);
}