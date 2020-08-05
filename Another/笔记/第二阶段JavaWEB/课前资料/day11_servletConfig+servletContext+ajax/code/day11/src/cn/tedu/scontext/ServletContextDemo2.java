package cn.tedu.scontext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取ServletContext对象
		ServletContext sc = this.getServletContext();
		String v1 = sc.getInitParameter("param1");
		String v2 = sc.getInitParameter("param2");
		//2.获取WEB应用的初始化参数
		System.out.println("v1: "+v1);
		System.out.println("v2: "+v2);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
