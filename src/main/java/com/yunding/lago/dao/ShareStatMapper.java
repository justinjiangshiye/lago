package com.yunding.lago.dao;

import com.yunding.lago.bean.ShareStat;

public interface ShareStatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShareStat record);

    int insertSelective(ShareStat record);

    ShareStat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShareStat record);

    int updateByPrimaryKeyWithBLOBs(ShareStat record);

    int updateByPrimaryKey(ShareStat record);
}