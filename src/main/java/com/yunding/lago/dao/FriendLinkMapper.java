package com.yunding.lago.dao;

import java.util.List;

import com.yunding.lago.bean.FriendLink;
import com.yunding.lago.bean.FriendLinkWithBLOBs;

public interface FriendLinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FriendLinkWithBLOBs record);

    int insertSelective(FriendLinkWithBLOBs record);

    FriendLinkWithBLOBs selectByPrimaryKey(Integer id);
    
    List<FriendLinkWithBLOBs> selectAllFriendLinks();
    
    int selectCount();

    int updateByPrimaryKeySelective(FriendLinkWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FriendLinkWithBLOBs record);

    int updateByPrimaryKey(FriendLink record);
	
	int updateFriendLinkLogicDelete(Integer id);
	
	int updateReorderFriendLink(Integer id);
	
	int updateMoveUp(Integer id);
	
	int updateMoveDown(Integer id);
}