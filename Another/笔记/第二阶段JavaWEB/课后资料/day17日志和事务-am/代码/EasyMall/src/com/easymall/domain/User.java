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
	//����javabean��session���е���ӹ���
	//��¼EasyMall
	public void valueBound(HttpSessionBindingEvent event) {
//		System.out.println("�û�["+username+"]�Ѿ���¼EasyMall.");
		logger.error("�û�["+username+"]�Ѿ���¼EasyMall.");
	}
	//����javabean��session���е��Ƴ�����
	//ע��EasyMall
	public void valueUnbound(HttpSessionBindingEvent event) {
//		System.out.println("�û�["+username+"]�Ѿ�ע��EasyMall.");
		logger.fatal("�û�["+username+"]�Ѿ�ע��EasyMall.");
		
	}
	

}
