package cn.tedu.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * response������: ʵ�ֶ�ʱˢ��
 * @author sz
 *
 */
public class ResponseDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("��ϲ��, ע��ɹ�, 3��֮����ת����ҳ....");
		
		//3��֮����ת����ҳ
		response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
