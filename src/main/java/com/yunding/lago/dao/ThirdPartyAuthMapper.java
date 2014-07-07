package com.yunding.lago.dao;

import com.yunding.lago.bean.ThirdPartyAuth;

public interface ThirdPartyAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ThirdPartyAuth record);

    int insertSelective(ThirdPartyAuth record);

    ThirdPartyAuth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ThirdPartyAuth record);

    int updateByPrimaryKey(ThirdPartyAuth record);
}