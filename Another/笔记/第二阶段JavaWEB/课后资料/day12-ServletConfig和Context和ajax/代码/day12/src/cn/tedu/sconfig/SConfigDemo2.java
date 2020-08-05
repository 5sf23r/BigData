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
		//��ǰ�������Ի�ȡһ��ServletConfig���͵Ķ���
		ServletConfig config = this.getServletConfig();
		//��ȡ��ǰSConfigDemo2�ĳ�ʼ��������Ϣ��
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
