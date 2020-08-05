package cn.tedu.sconfig;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.��ȡServletConfig����
		ServletConfig config = this.getServletConfig();
		
		//2.��ȡ��ǰServlet��ʼ������
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		
		System.out.println("driver: "+driver);
		System.out.println("url: "+url);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
