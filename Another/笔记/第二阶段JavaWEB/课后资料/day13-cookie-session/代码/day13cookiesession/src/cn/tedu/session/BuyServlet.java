package cn.tedu.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//���ﳵservlet
//��Ʒ��ӵĲ���
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String prod = request.getParameter("prod");
		prod = new String(prod.getBytes("iso8859-1"),"utf-8");
		
		//��session����������� ---�ڵ�ǰ�Ự��Χ��ʵ����Ʒ���ݵĹ���
		//����session
		HttpSession session = request.getSession();
		session.setAttribute("prod", prod);
		//����һ��JSESSIONID��cookie ����session�����ڱ��أ�
		//ʹ�������ιرմ򿪶��ܹ���ȡ��ͬһ��session
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*60*24);
		cookie.setPath(request.getContextPath()+"/");
		response.addCookie(cookie);
		
		//��ҳ����ʾ��Ʒ�����Ϣ��
		response.getWriter().write("�Ѿ�����Ʒ��"+prod+"�����빺�ﳵ");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
	
	
	
	
	
	
	
	
	

}
