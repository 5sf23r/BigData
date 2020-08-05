package com.easymall.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easymall.domain.User;
import com.easymall.exception.MsgException;
import com.easymall.service.UserService;

public class LoginServlet extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.��������������
		request.setCharacterEncoding("utf-8");
		//1.��ȡ����
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remname = request.getParameter("remname");
		//--�����ס�û�������
		if("true".equals(remname)){//���remnameΪ"true",��֤����¼�û�����ѡ��
			//����cookie�洢�û���
			Cookie cookie = new Cookie("username",URLEncoder.encode(username, "utf-8"));
			//�����������ʱ�䣬��cookie�����ڱ��ش���
			cookie.setMaxAge(3600*24*30);//��ֵ
			//����path
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
		}else{
			Cookie cookie = new Cookie("username","");
			//�����������ʱ�䣬��cookie�����ڱ��ش���
			cookie.setMaxAge(0);//��ֵ
			//����path
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
				
		}
		
		//2.����Service��ʵ�ֵ�¼�û�
		User user = null;
		try{
			UserService service = new UserService();
			user = service.loginUser(username,password);
		}catch (MsgException e) {
			//--�û������벻��ȷ���ص�ҳ����ʾ
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//--�û���������ȷ����¼�û���ת����ҳ
		request.getSession().setAttribute("user", user);
		response.sendRedirect("/index.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
