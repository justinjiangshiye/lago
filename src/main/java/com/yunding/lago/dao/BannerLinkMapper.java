package com.yunding.lago.dao;

import java.util.List;

import com.yunding.lago.bean.BannerLink;

public interface BannerLinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BannerLink record);

    int insertSelective(BannerLink record);

    BannerLink selectByPrimaryKey(Integer id);
    
    List<BannerLink> selectAllBannerLinks();
    
    int selectCount();

    int updateByPrimaryKeySelective(BannerLink record);

    int updateByPrimaryKeyWithBLOBs(BannerLink record);

    int updateByPrimaryKey(BannerLink record);
	
	int updateBannerLinkLogicDelete(Integer id);
	
	int updateReorderBannerLink(Integer id);
	
	int updateMoveUp(Integer id);
	
	int updateMoveDown(Integer id);
}