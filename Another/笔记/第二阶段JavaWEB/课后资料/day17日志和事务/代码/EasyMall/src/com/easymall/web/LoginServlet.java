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
//登录功能
public class LoginServlet extends HttpServlet {
	//代表User信息的Service层
	private UserService userService = new UserService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.乱码处理
		/*
		//2.获取用户信息request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remname = request.getParameter("remname");
		//获取用户是否选中30内自动登录复选框
		String autologin = request.getParameter("autologin");
		
		//如果remname值为true则要求记住用户名
		if("true".equals(remname)){
			//为true要求保存用户名
			Cookie cookie = new Cookie("remname",URLEncoder.encode(username, "utf-8"));
			cookie.setMaxAge(60*60*24*30);
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
		}else{
			//如果不为true则应该销毁cookie
			Cookie cookie = new Cookie("remname","");
			cookie.setMaxAge(0);
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
		}
		
		//判断30天内是否自动登录
		if("true".equals(autologin)) {
			//将cookie存储30天
			Cookie cookie = new Cookie("autologin",URLEncoder.encode(username,"utf-8")+"#"+MD5Utils.md5(password));
			cookie.setMaxAge(60*60*24*30);
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
		}
		
		
		
		//UserService负责接收javabean提供的数据
		//UserService提供处理数据的方法
		//将登陆功能的返回结果作为保存用户登陆信息使用。所以需要返回值对象
		User user =null;
		try {
			user = userService.loginUser(username,MD5Utils.md5(password));
			
		} catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//将用户信息保存仅入session域
		request.getSession().setAttribute("user", user);
		//回到首页
		response.sendRedirect(request.getContextPath()+"/");
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
