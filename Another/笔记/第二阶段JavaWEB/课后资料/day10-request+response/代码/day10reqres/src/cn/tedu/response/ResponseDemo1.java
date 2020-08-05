package cn.tedu.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 响应参数乱码处理
 * 	getOutputStream()
 *  getWriter()
 * @author Administrator
 *
 */
public class ResponseDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
		//通知浏览器使用utf-8字符集接收数据
//		response.setHeader("Content-Type", "text/html;charset=utf-8");
//		response.getOutputStream().write("中文".getBytes("utf-8"));
		//通知服务器使用utf-8字符集。
//		response.setCharacterEncoding("utf-8");
		//通知浏览器使用utf-8字符集。
		
		response.setHeader("Content-type", "text/html;charset=utf-8");
		response.getWriter().write("中文");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
