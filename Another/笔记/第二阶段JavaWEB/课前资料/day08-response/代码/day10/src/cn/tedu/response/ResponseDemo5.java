package cn.tedu.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//������֧��
		System.out.println("��ϲ��֧���ɹ�, ����100.00Ԫ......");
		
		//ʹ��ת����ת����ҳ
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		response.sendRedirect("/day10/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
