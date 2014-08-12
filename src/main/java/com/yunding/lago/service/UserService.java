/**
 * 
 */
package com.yunding.lago.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunding.lago.dao.*;
import com.yunding.lago.bean.*;

/**
 * @author justin
 *
 */
@Service
public class UserService {
	private UserMapper userMapper;
	@Autowired
	public void setUserMapper(UserMapper userMapper){
		this.userMapper = userMapper;
	}
	
	public User queryUserByUserId(String loginid){
		return this.userMapper.selectByUserId(loginid);
	}
	
	public int addUser(User user) {
		return this.userMapper.insertSelective(user);
	}
	
	public int updateUser(User user) {
		return this.userMapper.updateByPrimaryKeyWithBLOBs(user);
	}
}
