package com.easymall.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.log4j.Logger;

public class User implements HttpSessionBindingListener{
	private int id;
	private String username;
	private String password;
	private String nickname;
	private String email;
	
	public static Logger logger = Logger.getLogger(User.class);
	public User() {
		super();
	}
	public User(int id, String username, String password, String nickname,
			String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//监听javabean在session域中的添加过程
	//登录EasyMall
	public void valueBound(HttpSessionBindingEvent event) {
//		System.out.println("用户["+username+"]已经登录EasyMall.");
		logger.error("用户["+username+"]已经登录EasyMall.");
	}
	//监听javabean在session域中的移除过程
	//注销EasyMall
	public void valueUnbound(HttpSessionBindingEvent event) {
//		System.out.println("用户["+username+"]已经注销EasyMall.");
		logger.fatal("用户["+username+"]已经注销EasyMall.");
		
	}
	

}
