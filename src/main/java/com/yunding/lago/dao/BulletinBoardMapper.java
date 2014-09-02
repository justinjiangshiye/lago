package com.yunding.lago.dao;

import java.util.List;

import com.yunding.lago.bean.BulletinBoard;

public interface BulletinBoardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BulletinBoard record);

    int insertSelective(BulletinBoard record);

    BulletinBoard selectByPrimaryKey(Integer id);
    
    List<BulletinBoard> selectAllBulletinBoards();
    
    List<BulletinBoard> selectPublishedBulletinBoards();

    int updateByPrimaryKeySelective(BulletinBoard record);

    int updateByPrimaryKeyWithBLOBs(BulletinBoard record);

    int updateByPrimaryKey(BulletinBoard record);
}