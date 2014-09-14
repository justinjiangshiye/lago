package com.yunding.lago.dao;

import java.util.List;

import com.yunding.lago.bean.AppDownload;
import com.yunding.lago.bean.AppDownloadWithBLOBs;

public interface AppDownloadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppDownloadWithBLOBs record);

    int insertSelective(AppDownloadWithBLOBs record);

    AppDownloadWithBLOBs selectByPrimaryKey(Integer id);
    
    List<AppDownloadWithBLOBs> selectAllAppDownload();

    int updateByPrimaryKeySelective(AppDownloadWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AppDownloadWithBLOBs record);

    int updateByPrimaryKey(AppDownload record);
}