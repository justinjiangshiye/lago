package com.yunding.lago.dao;

import java.util.List;

import com.yunding.lago.bean.StaticPage;

public interface StaticPageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StaticPage record);

    int insertSelective(StaticPage record);

    StaticPage selectByPrimaryKey(Integer id);
    
    List<StaticPage> selectAllStaticPage();
    
    StaticPage selectByCategory(String category);

    int updateByPrimaryKeySelective(StaticPage record);

    int updateByPrimaryKeyWithBLOBs(StaticPage record);

    int updateByPrimaryKey(StaticPage record);
}