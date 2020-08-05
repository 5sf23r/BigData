package com.easymall.service;

import com.easymall.dao.UserDao;
import com.easymall.domain.User;
import com.easymall.exception.MsgException;

public class UserService {
	private UserDao userDao = new UserDao();
	/**
	 * �����û���������ʵ�ֵ�½���ܣ������û���Ϣ���󷵻�
	 * @param username �û���
	 * @param password ����
	 * @return �û���Ϣ����User
	 */
	public User loginUser(String username, String password) {
		
		User user = userDao.findUserByUsernameAndPassword(username,password);
		
		if(user != null){
			//����û���������ƥ�䣬��������½������ת����ҳ
			return user;
		}else{
			//����û��������벻ƥ�䣬����ʾ������Ϣ
			throw new MsgException("�û��������벻��ȷ");
		}
		
		
		
		
	}
	/**
	 * ע���û�
	 * @param user �û���Ϣ�������а���ȫ�����û���Ϣ����
	 */
	public void registUser(User user) {
		//�ж��û����Ƿ����
		User findUser = userDao.findUserByUsername(user.getUsername());
		
		if(findUser != null){
			//�����������ʾ������Ϣ�û����Ѵ���
			throw new MsgException("�û����Ѵ���");
		}else{
			//�������������������û�
			userDao.addUser(user);
		}
		
		
	}

	
	
	
	
	
	
	
	
}
