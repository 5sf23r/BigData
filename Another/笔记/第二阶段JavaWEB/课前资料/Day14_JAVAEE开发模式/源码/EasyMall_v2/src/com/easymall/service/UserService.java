package com.easymall.service;

import com.easymall.dao.UserDao;
import com.easymall.domain.User;
import com.easymall.exception.MsgException;

public class UserService {
	private UserDao userDao = new UserDao();
	/**
	 * 注册用户的方法
	 * @param user 封装了用户信息的bean
	 * 业务逻辑：检查用户名是否已经存在，如果已经存在，则抛异常，如果不存在正常注册
	 */
	public void registUser(User user) {
		User findUser = userDao.findUserByUserName(user.getUsername());
		if(findUser != null){
			//用户名已经存在，抛出异常
			throw new MsgException("用户名已存在！");
		}else{
			//用户名不存在，正常注册用户
			userDao.addUser(user);
		}
		
	}
	
	/**
	 * 登录用户方法
	 * @param username 要登录的用户名
	 * @param password 要登录的用户密码
	 */
	public User loginUser(String username, String password) {
		User user = userDao.findUserByUserNameAndPsw(username,password);
		if(user == null){
			throw new MsgException("用户名密码不正确！");
		}
		return user;
	}

}
