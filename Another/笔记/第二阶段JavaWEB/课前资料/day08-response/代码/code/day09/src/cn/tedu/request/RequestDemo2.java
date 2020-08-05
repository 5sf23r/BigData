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
 * request功能: 获取请求参数
 */
public class RequestDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getParameter(String name) -- String 通过name获得值
		// getParameterValues(String name) -- String[] 通过name获得多值 如: 爱好
		// getParameterNames() -- Enumeration<String> 获得所有请求参数的name
		// getParameterMap() -- Map<String,String[ ]> key :name value: 多值
		
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
		//注意: 这行代码一定要放在获取任何参数的代码之前执行, 否则无效!!
		//request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		
		//反向解码得出username对应的二机制序列
		byte[] bytes = username.getBytes("iso8859-1");
		username = new String(bytes, "utf-8");
		
		System.out.println("username: "+username);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
