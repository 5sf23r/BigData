package cn.tedu.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����ת��ϸ�ڣ�
 * 	2.����ת��ǰ�����䶼������ִ�С�
 *  	���Ұ�������ת����˳��ִ�С�
 *  3.����ʵ�ֶ���ת������������һ��servlet�ж������ת����
 * @author Administrator
 *
 */
public class RequestDemo8 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RequestDemo8 Start.....");
		request.getRequestDispatcher("/servlet/RequestDemo9").forward(request, response);
//		request.getRequestDispatcher("/servlet/RequestDemo10").forward(request, response);
		System.out.println("RequestDemo8 End.....");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
