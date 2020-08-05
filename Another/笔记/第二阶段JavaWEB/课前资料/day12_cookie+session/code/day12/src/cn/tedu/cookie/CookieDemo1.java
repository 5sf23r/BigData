package cn.tedu.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����ҳ����ʾ�ϴη���ʱ��
 */
public class CookieDemo1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�������
		response.setContentType("text/html;charset=utf-8");
		
		//��ȡʱ���ַ���
		String dateStr = new Date().toLocaleString();
		response.setHeader("Set-Cookie", "time="+dateStr);
		
		//��ȡ�ϴη���ʱ��
		String dateStr2 = request.getHeader("cookie");
		response.getWriter().write("���ϴη��ʵ�ʱ��Ϊ: "+dateStr2);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
