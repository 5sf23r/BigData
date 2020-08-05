package cn.tedu.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����������Ҫ������Դ
		//response.setDateHeader("Expires", -1); //1970-1-1
		//response.setHeader("Cache-control", "no-cache");
		
		
		//�������������һ����Դ
		response.setDateHeader("Expires", System.currentTimeMillis()+1000*60*60*24); //1970-1-1
		response.setHeader("Cache-control", "max-age=5");
		response.getWriter().write("hello servlet..."+new Date().toLocaleString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
