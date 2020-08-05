package com.easymall.service;

import com.easymall.dao.UserDao;
import com.easymall.domain.User;
import com.easymall.exception.MsgException;

public class UserService {
	private UserDao userDao = new UserDao();
	/**
	 * ע���û��ķ���
	 * @param user ��װ���û���Ϣ��bean
	 * ҵ���߼�������û����Ƿ��Ѿ����ڣ�����Ѿ����ڣ������쳣���������������ע��
	 */
	public void registUser(User user) {
		User findUser = userDao.findUserByUserName(user.getUsername());
		if(findUser != null){
			//�û����Ѿ����ڣ��׳��쳣
			throw new MsgException("�û����Ѵ��ڣ�");
		}else{
			//�û��������ڣ�����ע���û�
			userDao.addUser(user);
		}
		
	}
	
	/**
	 * ��¼�û�����
	 * @param username Ҫ��¼���û���
	 * @param password Ҫ��¼���û�����
	 */
	public User loginUser(String username, String password) {
		User user = userDao.findUserByUserNameAndPsw(username,password);
		if(user == null){
			throw new MsgException("�û������벻��ȷ��");
		}
		return user;
	}

}
