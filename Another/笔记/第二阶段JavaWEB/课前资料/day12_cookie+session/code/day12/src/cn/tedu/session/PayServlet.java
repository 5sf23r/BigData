package cn.tedu.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ȡ�����ﳵ�е���Ʒ, Ϊ�����
 */
public class PayServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//1.��ȡsession
		HttpSession session = request.getSession(false);
		if(session != null){
			String prod = (String) session.getAttribute("prod");
			response.getWriter().write("�ɹ�Ϊ[ "+prod+" ]��Ʒ����, ֧��10000.00$...");
		}else{
			response.getWriter().write("����û�н��κ���Ʒ���빺�ﳵ...");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
