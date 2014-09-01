package com.yunding.lago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunding.lago.bean.*;
import com.yunding.lago.dao.*;

@Service
public class StaticPageService {
	private StaticPageMapper staticPageMapper = null;
	@Autowired
	public void setStaticPageMapper(StaticPageMapper staticPageMapper) {
		this.staticPageMapper = staticPageMapper;
	}
	
	public List<StaticPage> queryAllStaticPages() {
		return this.staticPageMapper.selectAllStaticPage();
	}
	
	public StaticPage queryStaticPageByCategory(String category) {
		return this.staticPageMapper.selectByCategory(category);
	}
	
	public Integer addStaticPage(StaticPage staticPage) {
		return this.staticPageMapper.insertSelective(staticPage);
	}
	
	public Integer updateStaticPage(StaticPage staticPage) {
		return this.staticPageMapper.updateByPrimaryKeyWithBLOBs(staticPage);
	}
}
