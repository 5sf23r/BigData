package cn.tedu.request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * request����: ��ȡ�������
 */
public class RequestDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getParameter(String name) -- String ͨ��name���ֵ
		// getParameterValues(String name) -- String[] ͨ��name��ö�ֵ ��: ����
		// getParameterNames() -- Enumeration<String> ����������������name
		// getParameterMap() -- Map<String,String[ ]> key :name value: ��ֵ
		
		/*
		String username = request.getParameter("username");
		System.out.println("username: "+username);
		
		String[] likes = request.getParameterValues("like");
		System.out.println(Arrays.toString(likes));
		
		System.out.println("---------------------");
		
		Enumeration names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String[] values = request.getParameterValues(name);
			System.out.println(name+" : "+Arrays.toString(values));
		}
		
		Map<String, String[]> map = request.getParameterMap();
		System.out.println("map");
		*/
		//ע��: ���д���һ��Ҫ���ڻ�ȡ�κβ����Ĵ���֮ǰִ��, ������Ч!!
		//request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		
		//�������ó�username��Ӧ�Ķ���������
		byte[] bytes = username.getBytes("iso8859-1");
		username = new String(bytes, "utf-8");
		
		System.out.println("username: "+username);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
