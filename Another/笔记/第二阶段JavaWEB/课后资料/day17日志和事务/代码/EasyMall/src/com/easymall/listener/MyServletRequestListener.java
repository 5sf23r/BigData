package com.easymall.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.easymall.domain.User;

public class MyServletRequestListener implements ServletRequestListener {
	public static Logger logger = Logger.getLogger(MyServletRequestListener.class);
	//�û��������
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		//�û�δ��¼״̬��usernameֵ
		String username = "�ο�";
		//�û���
		//�жϵ�ǰ�������Ƿ�����û��ĵ�¼��Ϣ
		if(request.getSession(false) != null 
				&& request.getSession().getAttribute("user") != null){
			User user = (User) request.getSession().getAttribute("user");
			username = user.getUsername();
		}
		
		//�û�ip
		String ip = request.getRemoteAddr();
		//�û������url��ַ
		String url = request.getRequestURL().toString();
//		System.out.println("�û�["+username+"]|ip:"+ip+"|url:"+url+"���ʽ���");
		logger.debug("�û�["+username+"]|ip:"+ip+"|url:"+url+"���ʽ���");
		
		
	}

	
	//�û�����ʼ
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		//�û�δ��¼״̬��usernameֵ
		String username = "�ο�";
		//�û���
		//�жϵ�ǰ�������Ƿ�����û��ĵ�¼��Ϣ
		if(request.getSession(false) != null 
				&& request.getSession().getAttribute("user") != null){
			User user = (User) request.getSession().getAttribute("user");
			username = user.getUsername();
		}
		
		//�û�ip
		String ip = request.getRemoteAddr();
		//�û������url��ַ
		String url = request.getRequestURL().toString();
//		System.out.println("�û�["+username+"]|ip:"+ip+"|url:"+url+"���ʿ�ʼ");
		logger.debug("�û�["+username+"]|ip:"+ip+"|url:"+url+"���ʿ�ʼ");
	}

}
