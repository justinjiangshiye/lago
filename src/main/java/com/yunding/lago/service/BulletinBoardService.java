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
		return this.bulletinBoardMapper.selectAllBulletinBorads();
	}

	public List<BulletinBoard> queryPublishedBulletinBoards() {
		return this.bulletinBoardMapper.selectPublishedBulletinBoards();
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
}
