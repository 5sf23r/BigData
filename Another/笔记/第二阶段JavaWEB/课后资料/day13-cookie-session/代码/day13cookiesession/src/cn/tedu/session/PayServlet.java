package cn.tedu.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//����servlet
//����Ʒ����۸񲢷��͵������
public class PayServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//��ȡsession����
		HttpSession session = request.getSession();
		//��ȡsession���е�����
		String prod = (String) session.getAttribute("prod");
		if(prod == null){
			
			response.getWriter().write("����δѡ���κ���Ʒ");
		}else{
			
			//���������ʾ������Ϣ��
			response.getWriter().write("�Ѹ�����Ʒ��"+prod+"�����۸�10000000");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
