package cn.tedu.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * request������: ʵ���������
 */
public class RequestDemo6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("demo6.....before...");
		
		
		//��demo7����������
		request.getRequestDispatcher("/servlet/RequestDemo7").include(request, response);
		
		
		response.getWriter().write("demo6.....after...");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
