package com.easymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.杀死session，用户登出
		if(request.getSession(false) != null){
			request.getSession().invalidate();
		}
		//2.删除30天内自动登录cookie
		Cookie autologinc = new Cookie("autologin","");
		autologinc.setPath("/");
		autologinc.setMaxAge(0);
		response.addCookie(autologinc);
		//3.重定向回主页
		response.sendRedirect("/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
