package cn.tedu.request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �������ʵ��
 * ��Demo13һ�� 
 * @author Administrator
 *
 */
public class RequestDemo12 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("aaa");
		//��ȡһ��������
		//���õ�����ʵ���������
		request.getRequestDispatcher("/servlet/RequestDemo13").include(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
