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
import com.easymall.utils.MD5Utils;

public class LoginServlet extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			user = service.loginUser(username,MD5Utils.md5(password));
		}catch (MsgException e) {
			//--用户名密码不正确，回到页面提示
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		//--用户名密码正确，登录用户
		request.getSession().setAttribute("user", user);
		
		//--处理30天内自动登录
		String autologin = request.getParameter("autologin");
		if("true".equals(autologin)){
			//--勾选过30天内自动登录，则发送cookie保存用户名 密码
			Cookie autologinc = new Cookie("autologin",URLEncoder.encode(username,"utf-8")+"#"+MD5Utils.md5(password));
			autologinc.setPath("/");
			autologinc.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(autologinc);
		}
		
		//跳转回主页
		response.sendRedirect("/index.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
