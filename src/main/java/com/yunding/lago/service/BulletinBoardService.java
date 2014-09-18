/**
 * 
 */
package com.yunding.lago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunding.lago.bean.BulletinBoard;
import com.yunding.lago.dao.BulletinBoardMapper;

/**
 * @author justin
 *
 */
@Service
public class BulletinBoardService {
	private BulletinBoardMapper bulletinBoardMapper = null;
	@Autowired
	public void setBulletinBoardMapper(BulletinBoardMapper bulletinBoardMapper) {
		this.bulletinBoardMapper = bulletinBoardMapper;
	}

	public List<BulletinBoard> queryAllBulletinBoards() {
		return this.bulletinBoardMapper.selectAllBulletinBoards();
	}

	public List<BulletinBoard> queryPublishedBulletinBoards() {
		return this.bulletinBoardMapper.selectPublishedBulletinBoards();
	}
	
	public int queryCount() {
		return this.bulletinBoardMapper.selectCount();
	}
	
	public BulletinBoard queryBulletinBoardById(Integer id) {
		return this.bulletinBoardMapper.selectByPrimaryKey(id);
	}
	
	public int addBulletinBoard(BulletinBoard bulletinBoard) {
		return this.bulletinBoardMapper.insertSelective(bulletinBoard);
	}
	
	public int updateBulletinBoard(BulletinBoard bulletinBoard) {
		return this.bulletinBoardMapper.updateByPrimaryKeyWithBLOBs(bulletinBoard);
	}
	
	public int deleteBulletinBoardByPrimaryKey(Integer id) {
		this.bulletinBoardMapper.updateReorderBulletinBoard(id);
		return this.bulletinBoardMapper.updateBulletinBoardLogicDelete(id);
	}
	
	public int updateMoveUp(Integer id) {
		return this.bulletinBoardMapper.updateMoveUp(id);
	}
	
	public int updateMoveDown(Integer id) {
		return this.bulletinBoardMapper.updateMoveDown(id);
	}
}
