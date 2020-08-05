package cn.tedu.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 请求当中包含的客户端参数：
 * 	获取客户端参数的API
 * @author Administrator
 *
 */
public class RequestDemo1 extends HttpServlet {
//	getRequestURL方法 -- 返回客户端发出请求完整URL
//	getRequestURI方法 -- 返回请求行中的资源名部分
//	getQueryString方法 -- 返回请求行中的参数部分
//	getRemoteAddr方法 -- 返回发出请求的客户机的IP地址
//	getMethod -- 得到客户机请求方式
//	!!getContextPath -- 获得当前web应用虚拟目录名称 -- 在写路径时不要将web应用的虚拟路径的名称写死, 应该在需要写web应用的名称的地方通过getContextPath方法动态获取

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		System.out.println("url:"+url);
		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);
		String qs = request.getQueryString();
		System.out.println("qs:"+qs);
		String ip = request.getRemoteAddr();//ipconfig
		System.out.println("ip:"+ip);
		String method = request.getMethod();
		System.out.println("method:"+method);
		String cp = request.getContextPath();
		System.out.println("cp:"+cp);    //request.getContextPath()+/servlet
		
		
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
