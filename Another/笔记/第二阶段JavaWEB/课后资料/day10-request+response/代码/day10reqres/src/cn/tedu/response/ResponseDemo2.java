package cn.tedu.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �����ض���
 * 	
 * @author Administrator
 *
 */
public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.����302״̬��
//		response.setStatus(302);
		//2.����location��Ӧͷ
//		response.setHeader("location", "http://www.tmooc.cn");
//		response.setHeader("location", request.getContextPath()+"/servlet/ResponseDemo1");
		response.sendRedirect("http://www.baidu.com");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
