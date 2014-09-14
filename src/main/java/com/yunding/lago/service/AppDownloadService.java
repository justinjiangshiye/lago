package com.yunding.lago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunding.lago.bean.AppDownloadWithBLOBs;
import com.yunding.lago.dao.AppDownloadMapper;

@Service
public class AppDownloadService {
	private AppDownloadMapper appDownloadMapper = null;
	@Autowired
	public void setAppDownloadMapper(AppDownloadMapper appDownloadMapper) {
		this.appDownloadMapper = appDownloadMapper;
	}

	public List<AppDownloadWithBLOBs> queryAllAppDownloads() {
		return this.appDownloadMapper.selectAllAppDownload();
	}
	
	public AppDownloadWithBLOBs queryAppDownloadById(Integer id) {
		return this.appDownloadMapper.selectByPrimaryKey(id);
	}
	
	public int addAppDownload(AppDownloadWithBLOBs AppDownloadWithBLOBs) {
		return this.appDownloadMapper.insertSelective(AppDownloadWithBLOBs);
	}
	
	public int updateAppDownload(AppDownloadWithBLOBs AppDownloadWithBLOBs) {
		return this.appDownloadMapper.updateByPrimaryKeyWithBLOBs(AppDownloadWithBLOBs);
	}
}
