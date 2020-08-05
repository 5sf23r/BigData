package cn.tedu.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * request������: ʵ������ת��
 */
public class RequestDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RequestDemo3.doGet()....before...");
		
		//response.getWriter().write("demo3......");
		//response.flushBuffer();
		
		//ʵ������ת��
		request.getRequestDispatcher("/servlet/RequestDemo4").forward(request, response);
		
		
		System.out.println("RequestDemo3.doGet()....after...");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
