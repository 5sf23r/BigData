package cn.tedu.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * request功能: 获取客户端基本信息 request功能: 获取请求头信息
 */
public class RequestDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* request功能: 获取客户端基本信息 */
		// getRequestURL方法 -- 返回客户端发出请求完整URL
		String url = request.getRequestURL().toString();
		System.out.println("url: " + url);

		// getRequestURI方法 -- 返回请求行中的资源名部分
		String uri = request.getRequestURI();
		System.out.println("uri: " + uri);

		// getQueryString方法 -- 返回请求行中的参数部分
		String qs = request.getQueryString();
		System.out.println("qs: " + qs);

		// getRemoteAddr方法 -- 返回发出请求的客户机的IP地址
		String ip = request.getRemoteAddr();
		System.out.println("ip: " + ip);

		// getMethod方法 -- 返回客户机的请求方式
		String method = request.getMethod();
		System.out.println("method: " + method);

		// !!!getContextPath方法 -- 获得当前web应用的虚拟目录名称

		String contextpath = request.getContextPath();
		System.out.println("cp: " + contextpath);

		// response.sendRedirect(request.getContextPath()+"/index.jsp");

		// ================================================

		/* request功能: 获取请求头信息 */
		// getHeader(name)方法 --- String
		
		String host = request.getHeader("host");
		System.out.println("host: "+host);
		
		// getHeaders(String name)方法 --- Enumeration<String>
		Enumeration values = request.getHeaders("host");
		while (values.hasMoreElements()) {
			String value = (String) values.nextElement();
			System.out.println("value: "+value);
		}
		
		// getHeaderNames方法 --- Enumeration<String>
		Enumeration headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = (String) headers.nextElement();
			String value = request.getHeader(header);
			System.out.println(header+" : "+value);
		}
		
		// getIntHeader(name)方法 --- int
		// getDateHeader(name)方法 --- long(日期对应毫秒)
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
