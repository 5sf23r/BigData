package com.easymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ע���û���¼״̬
public class LogOutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ע���û���¼״̬���Խ�sessionɾ����ɾ��session�����е�����ֵҲ������
		//ʵ���û�ע���Ĺ���
		//���ж�session�����Ƿ�Ϊ�գ����Ϊ������Ҫ�ͷš�
		//��Ϊ�����ͷš�
		if(request.getSession(false)!=null){
			request.getSession().invalidate();
		}
		//30�����Զ���¼���cookie��������֮���ظ���¼����Ҫ�ȴ�30��
		Cookie cookie = new Cookie("autologin","");
		cookie.setMaxAge(0);
		cookie.setPath(request.getContextPath()+"/");
		response.addCookie(cookie);
		
		response.sendRedirect("http://www.easymall.com");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
