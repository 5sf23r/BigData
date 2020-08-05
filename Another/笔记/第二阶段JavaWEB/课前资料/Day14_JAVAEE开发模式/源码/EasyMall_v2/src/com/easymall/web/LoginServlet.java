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
		//0.解决请求参数乱码
		request.setCharacterEncoding("utf-8");
		//1.获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remname = request.getParameter("remname");
		//--处理记住用户名功能
		if("true".equals(remname)){//如果remname为"true",则证明记录用户名被选中
			//利用cookie存储用户名
			Cookie cookie = new Cookie("username",URLEncoder.encode(username, "utf-8"));
			//设置最大生存时间，将cookie保存在本地磁盘
			cookie.setMaxAge(3600*24*30);//秒值
			//设置path
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
		}else{
			Cookie cookie = new Cookie("username","");
			//设置最大生存时间，将cookie保存在本地磁盘
			cookie.setMaxAge(0);//秒值
			//设置path
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
				
		}
		
		//2.调用Service来实现登录用户
		User user = null;
		try{
			UserService service = new UserService();
			user = service.loginUser(username,password);
		}catch (MsgException e) {
			//--用户名密码不正确，回到页面提示
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//--用户名密码正确，登录用户，转回主页
		request.getSession().setAttribute("user", user);
		response.sendRedirect("/index.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
