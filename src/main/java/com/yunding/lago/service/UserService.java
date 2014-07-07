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
	
	public User getUserById(Integer id){
		return this.userMapper.selectByPrimaryKey(id);
	}
}
