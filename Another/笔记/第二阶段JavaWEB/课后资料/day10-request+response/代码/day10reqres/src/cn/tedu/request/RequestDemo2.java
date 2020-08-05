package cn.tedu.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 获取请求中的头信息
 * @author Administrator
 *
 */
public class RequestDemo2 extends HttpServlet {
//	getHeader(name)方法 --- String 
//	getHeaders(String name)方法 --- Enumeration<String>
//	getHeaderNames方法 --- Enumeration<String>
//	getIntHeader(name)方法  --- int
//	getDateHeader(name)方法 --- long(日期对应毫秒)

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String host = request.getHeader("Host");
		System.out.println("host:"+host);
		
		//getHeaders方法可以获取多个同名的请求头对应的内容，
		//这些内容会放入一个迭代器中,可以通过遍历循环获取。
		Enumeration<String> headers = request.getHeaders("Host");
		while (headers.hasMoreElements()) {
			String string = (String) headers.nextElement();
			System.out.println("head:"+string);
		}
		
		//获取全部的请求头
		//快捷键获取返回值：Alt+Shift+L; 注意：光标放在最后。
		Enumeration<String> headernames = request.getHeaderNames();
		while (headernames.hasMoreElements()) {
			//遍历全部请求头的名称：
			String string = (String) headernames.nextElement();
			//根据请求头获取全部头对应的值。
			String value = request.getHeader(string);
			System.out.println("header:"+string+">>>>value:"+value);
		}
		
		
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
