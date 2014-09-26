/**
 * 
 */
package com.yunding.lago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunding.lago.dao.*;
import com.yunding.lago.bean.*;

/**
 * @author justin
 *
 */
@Service
public class VisitLogService {
	private VisitLogMapper visitLogMapper;
	@Autowired
	public void setVisitLogMapper(VisitLogMapper visitLogMapper){
		this.visitLogMapper = visitLogMapper;
	}
	
	public VisitLog queryVisitLogById(Integer id){
		return this.visitLogMapper.selectByPrimaryKey(id);
	}
	
	public int queryCount() {
		return this.visitLogMapper.selectCount();
	}
	
	public int addVisitLog(VisitLog visitLog) {
		return this.visitLogMapper.insertSelective(visitLog);
	}
}
