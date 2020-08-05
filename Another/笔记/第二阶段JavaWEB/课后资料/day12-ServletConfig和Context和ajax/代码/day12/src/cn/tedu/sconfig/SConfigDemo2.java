package cn.tedu.sconfig;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SConfigDemo2 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//当前方法可以获取一个ServletConfig类型的对象
		ServletConfig config = this.getServletConfig();
		//获取当前SConfigDemo2的初始化配置信息。
		String key = config.getInitParameter("key");
		System.out.println("key:"+key);
		String key2 = config.getInitParameter("key2");
		System.out.println("key2:"+key2);
		String driver = config.getInitParameter("driver");
		System.out.println("key2:"+driver);
		String url = config.getInitParameter("url");
		System.out.println("key2:"+url);
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println("name:"+name);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
