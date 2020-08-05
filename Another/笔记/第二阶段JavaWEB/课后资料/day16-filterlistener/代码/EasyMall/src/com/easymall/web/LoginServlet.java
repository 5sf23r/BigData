package com.easymall.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easymall.domain.User;
import com.easymall.exception.MsgException;
import com.easymall.service.UserService;
import com.easymall.utils.JDBCUtils;
import com.easymall.utils.MD5Utils;
//��¼����
public class LoginServlet extends HttpServlet {
	//����User��Ϣ��Service��
	private UserService userService = new UserService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.���봦��
		/*
		//2.��ȡ�û���Ϣrequest.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remname = request.getParameter("remname");
		//��ȡ�û��Ƿ�ѡ��30���Զ���¼��ѡ��
		String autologin = request.getParameter("autologin");
		
		//���remnameֵΪtrue��Ҫ���ס�û���
		if("true".equals(remname)){
			//ΪtrueҪ�󱣴��û���
			Cookie cookie = new Cookie("remname",URLEncoder.encode(username, "utf-8"));
			cookie.setMaxAge(60*60*24*30);
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
		}else{
			//�����Ϊtrue��Ӧ������cookie
			Cookie cookie = new Cookie("remname","");
			cookie.setMaxAge(0);
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
		}
		
		//�ж�30�����Ƿ��Զ���¼
		if("true".equals(autologin)) {
			//��cookie�洢30��
			Cookie cookie = new Cookie("autologin",URLEncoder.encode(username,"utf-8")+"#"+MD5Utils.md5(password));
			cookie.setMaxAge(60*60*24*30);
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
		}
		
		
		
		//UserService�������javabean�ṩ������
		//UserService�ṩ�������ݵķ���
		//����½���ܵķ��ؽ����Ϊ�����û���½��Ϣʹ�á�������Ҫ����ֵ����
		User user =null;
		try {
			user = userService.loginUser(username,MD5Utils.md5(password));
			
		} catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//���û���Ϣ�������session��
		request.getSession().setAttribute("user", user);
		//�ص���ҳ
		response.sendRedirect(request.getContextPath()+"/");
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
