package cn.tedu.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ����Ʒ���빺�ﳵ
 */
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.��ȡ��Ʒ��Ϣ
		String prod = request.getParameter("prod");
		prod = new String(prod.getBytes("iso8859-1"), "utf-8");
		
		//2.��ȡsession����
		HttpSession session = request.getSession();//�����sessionֱ���ù���, ���û��session�ʹ���һ���µ��ù���
		session.setAttribute("prod", prod);
		
		response.setContentType("text/html;charset=utf-8");
		
		//���ñ���sessionid��cookie�������ʱ��.
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setPath(request.getContextPath()+"/");
		cookie.setMaxAge(30*60);
		response.addCookie(cookie);
		
		//3.������Ӧ
		response.getWriter().write("��ϲ��, �ɹ���[ "+prod+" ]��Ʒ�����˹��ﳵ...");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
