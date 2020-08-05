package cn.tedu.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * response功能二: 实现请求重定向
 */
public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ResponseDemo2.doGet().......");
		
		//response.setStatus(302);
		
		//response.setHeader("location", request.getContextPath()+"/servlet/ResponseDemo3");
		//response.setHeader("location", "/day09/index.jsp");
		//response.setHeader("location", "http://www.tmooc.cn");
		
		response.sendRedirect("http://www.tmooc.cn");
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
