package cn.tedu.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����ת��ʵ��
 * 	��RequestDemo5һ��
 * @author Administrator
 *
 */
public class RequestDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����ת��
		//��ȡһ��������
		RequestDispatcher rd = request.getRequestDispatcher("/servlet/RequestDemo5");
		//���õ�����ʵ������ת��
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
