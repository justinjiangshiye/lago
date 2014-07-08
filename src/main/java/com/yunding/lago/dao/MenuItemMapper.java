package com.yunding.lago.dao;

import com.yunding.lago.bean.MenuItem;

public interface MenuItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuItem record);

    int insertSelective(MenuItem record);

    MenuItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuItem record);

    int updateByPrimaryKey(MenuItem record);
}