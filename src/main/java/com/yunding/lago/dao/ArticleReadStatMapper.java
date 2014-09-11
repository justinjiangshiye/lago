package com.yunding.lago.dao;

import com.yunding.lago.bean.ArticleReadStat;

public interface ArticleReadStatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleReadStat record);

    int insertSelective(ArticleReadStat record);

    ArticleReadStat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleReadStat record);

    int updateByPrimaryKey(ArticleReadStat record);
}