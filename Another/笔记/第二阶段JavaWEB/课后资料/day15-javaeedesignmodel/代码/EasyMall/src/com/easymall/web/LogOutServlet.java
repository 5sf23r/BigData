package com.easymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//注销用户登录状态
public class LogOutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//注销用户登录状态可以将session删除，删除session后其中的属性值也会销毁
		//实现用户注销的功能
		//先判断session对象是否为空，如果为空则不需要释放。
		//不为空再释放。
		if(request.getSession(false)!=null){
			request.getSession().invalidate();
		}
		
		response.sendRedirect("http://www.easymall.com");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
