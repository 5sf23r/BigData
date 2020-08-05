package com.easymall.service;

import com.easymall.dao.UserDao;
import com.easymall.domain.User;
import com.easymall.exception.MsgException;

public class UserService {
	private UserDao userDao = new UserDao();
	/**
	 * 根据用户名和密码实现登陆功能，并将用户信息对象返回
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户信息对象User
	 */
	public User loginUser(String username, String password) {
		
		User user = userDao.findUserByUsernameAndPassword(username,password);
		
		if(user != null){
			//如果用户名和密码匹配，则正常登陆，并跳转到首页
			return user;
		}else{
			//如果用户名和密码不匹配，则提示错误信息
			throw new MsgException("用户名或密码不正确");
		}
		
		
		
		
	}
	/**
	 * 注册用户
	 * @param user 用户信息对象，其中包含全部的用户信息参数
	 */
	public void registUser(User user) {
		//判断用户名是否存在
		User findUser = userDao.findUserByUsername(user.getUsername());
		
		if(findUser != null){
			//如果存在则提示错误信息用户名已存在
			throw new MsgException("用户名已存在");
		}else{
			//如果不存在则正常添加用户
			userDao.addUser(user);
		}
		
		
	}

	
	
	
	
	
	
	
	
}
