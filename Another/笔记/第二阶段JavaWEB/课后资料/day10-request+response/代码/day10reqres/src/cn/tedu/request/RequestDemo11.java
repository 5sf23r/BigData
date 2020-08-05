package cn.tedu.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��Ϊ�����ʹ�ã�
 * 		�������������
 * 		����ת������ҳչʾ��
 * @author Administrator
 *
 */
public class RequestDemo11 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = "lishuai";
		int age = 19;
		String addr = "bj";
		String gender = "��";
		//��һ��������ݵ�request����
		request.setAttribute("username", username);
		request.setAttribute("age", age);
		request.setAttribute("addr", addr);
		request.setAttribute("gender", gender);
		//��������ݺ�����ת������ҳ
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
