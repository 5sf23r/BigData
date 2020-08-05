package cn.tedu.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * response功能一: 向客户端发送数据
 */
public class ResponseDemo1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//getOutputStream()
		//response.getOutputStream().write("aaa".getBytes());
		
		//发送数据指定使用utf-8
		//response.getOutputStream().write("中国".getBytes("utf-8"));
		
		//通知浏览器使用utf-8来接受数据
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		//==========================================
		
		//getWriter()
		
		//通知服务器使用utf-8来发送数据
		//response.setCharacterEncoding("utf-8");
		
		//通知浏览器也使用utf-8来接受数据
		response.setContentType("text/html;charset=utf-8");
		
		//response.getOutputStream().write("中国".getBytes("utf-8"));
		response.getWriter().write("中国");//iso8859-1
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
