package cn.tedu.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��Ӧ�������봦��
 * 	getOutputStream()
 *  getWriter()
 * @author Administrator
 *
 */
public class ResponseDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
		//֪ͨ�����ʹ��utf-8�ַ�����������
//		response.setHeader("Content-Type", "text/html;charset=utf-8");
//		response.getOutputStream().write("����".getBytes("utf-8"));
		//֪ͨ������ʹ��utf-8�ַ�����
//		response.setCharacterEncoding("utf-8");
		//֪ͨ�����ʹ��utf-8�ַ�����
		
		response.setHeader("Content-type", "text/html;charset=utf-8");
		response.getWriter().write("����");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
