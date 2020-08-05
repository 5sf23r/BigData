package cn.tedu.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 请求重定向：
 * 	
 * @author Administrator
 *
 */
public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.设置302状态码
//		response.setStatus(302);
		//2.设置location响应头
//		response.setHeader("location", "http://www.tmooc.cn");
//		response.setHeader("location", request.getContextPath()+"/servlet/ResponseDemo1");
		response.sendRedirect("http://www.baidu.com");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
