package com.yunding.lago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yunding.lago.bean.*;
import com.yunding.lago.dao.*;

public class MenuItemService {
	private MenuItemMapper menuItemMapper = null;
	@Autowired
	public void setArticleMapper(MenuItemMapper menuItemMapper) {
		this.menuItemMapper = menuItemMapper;
	}
	
	public List<MenuItem> queryHomePageArticles() throws Exception {
		throw new Exception("queryHomePageArticles not implemented.");
	}
}
