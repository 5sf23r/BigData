package cn.tedu.scontext;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo3 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取ServletContext对象
		ServletContext sc = this.getServletContext();
		
		//2.加载config.properties文件的内容
		//String path = "/config.properties";
		//String path = "config.properties";
		//String path = "E:\\software\\tomcat7.0\\webapps\\day11\\WEB-INF\\classes\\config.properties";
		String path = "/WEB-INF/classes/config.properties";
		path = sc.getRealPath(path);
		File file = new File(path);
		System.out.println("文件路径: "+file.getAbsolutePath());
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
