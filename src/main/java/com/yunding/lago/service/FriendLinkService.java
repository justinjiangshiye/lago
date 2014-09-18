package com.yunding.lago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunding.lago.bean.FriendLinkWithBLOBs;
import com.yunding.lago.dao.FriendLinkMapper;

@Service
public class FriendLinkService {
	private FriendLinkMapper friendLinkMapper = null;
	@Autowired
	public void setFriendLinkMapper(FriendLinkMapper friendLinkMapper) {
		this.friendLinkMapper = friendLinkMapper;
	}

	public List<FriendLinkWithBLOBs> queryAllFriendLinks() {
		return this.friendLinkMapper.selectAllFriendLinks();
	}
	
	public FriendLinkWithBLOBs queryFriendLinkById(Integer id) {
		return this.friendLinkMapper.selectByPrimaryKey(id);
	}
	
	public int queryCount() {
		return this.friendLinkMapper.selectCount();
	}
	
	public int addFriendLink(FriendLinkWithBLOBs friendLinkWithBLOBs) {
		return this.friendLinkMapper.insertSelective(friendLinkWithBLOBs);
	}
	
	public int updateFriendLink(FriendLinkWithBLOBs friendLinkWithBLOBs) {
		return this.friendLinkMapper.updateByPrimaryKeyWithBLOBs(friendLinkWithBLOBs);
	}
	
	public int deleteFriendLinkByPrimaryKey(Integer id) {
		this.friendLinkMapper.updateReorderFriendLink(id);
		return this.friendLinkMapper.updateFriendLinkLogicDelete(id);
	}
	
	public int updateMoveUp(Integer id) {
		return this.friendLinkMapper.updateMoveUp(id);
	}
	
	public int updateMoveDown(Integer id) {
		return this.friendLinkMapper.updateMoveDown(id);
	}
}
