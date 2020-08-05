package com.easymall.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.easymall.domain.User;

public class MyServletRequestListener implements ServletRequestListener {
	public static Logger logger = Logger.getLogger(MyServletRequestListener.class);
	//用户请求结束
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		//用户未登录状态的username值
		String username = "游客";
		//用户名
		//判断当前请求中是否包含用户的登录信息
		if(request.getSession(false) != null 
				&& request.getSession().getAttribute("user") != null){
			User user = (User) request.getSession().getAttribute("user");
			username = user.getUsername();
		}
		
		//用户ip
		String ip = request.getRemoteAddr();
		//用户请求的url地址
		String url = request.getRequestURL().toString();
//		System.out.println("用户["+username+"]|ip:"+ip+"|url:"+url+"访问结束");
		logger.debug("用户["+username+"]|ip:"+ip+"|url:"+url+"访问结束");
		
		
	}

	
	//用户请求开始
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		//用户未登录状态的username值
		String username = "游客";
		//用户名
		//判断当前请求中是否包含用户的登录信息
		if(request.getSession(false) != null 
				&& request.getSession().getAttribute("user") != null){
			User user = (User) request.getSession().getAttribute("user");
			username = user.getUsername();
		}
		
		//用户ip
		String ip = request.getRemoteAddr();
		//用户请求的url地址
		String url = request.getRequestURL().toString();
//		System.out.println("用户["+username+"]|ip:"+ip+"|url:"+url+"访问开始");
		logger.debug("用户["+username+"]|ip:"+ip+"|url:"+url+"访问开始");
	}

}
