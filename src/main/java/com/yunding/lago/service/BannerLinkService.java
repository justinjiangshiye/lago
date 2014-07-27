package com.yunding.lago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunding.lago.bean.BannerLink;
import com.yunding.lago.dao.BannerLinkMapper;

@Service
public class BannerLinkService {
	private BannerLinkMapper bannerLinkMapper = null;
	@Autowired
	public void setBannerLinkMapper(BannerLinkMapper bannerLinkMapper) {
		this.bannerLinkMapper = bannerLinkMapper;
	}
	
	public List<BannerLink> queryAllBannerLinks() {
		return this.bannerLinkMapper.selectAllBannerLinks();
	}

	public BannerLink queryBannerLinkById(Integer id) {
		return this.bannerLinkMapper.selectByPrimaryKey(id);
	}
	
	public int addBannerLink(BannerLink bannerLink) {
		return this.bannerLinkMapper.insertSelective(bannerLink);
	}
	
	public int updateBannerLink(BannerLink bannerLink) {
		return this.bannerLinkMapper.updateByPrimaryKeyWithBLOBs(bannerLink);
	}
}
