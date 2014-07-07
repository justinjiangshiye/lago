package com.yunding.lago.dao;

import com.yunding.lago.bean.FriendLink;
import com.yunding.lago.bean.FriendLinkWithBLOBs;

public interface FriendLinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FriendLinkWithBLOBs record);

    int insertSelective(FriendLinkWithBLOBs record);

    FriendLinkWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FriendLinkWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FriendLinkWithBLOBs record);

    int updateByPrimaryKey(FriendLink record);
}