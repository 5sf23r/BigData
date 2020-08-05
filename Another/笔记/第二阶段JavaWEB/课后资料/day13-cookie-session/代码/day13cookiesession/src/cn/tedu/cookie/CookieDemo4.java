package cn.tedu.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ɾ��cookie
public class CookieDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����һ��name��path��Ҫɾ������ȫһ�µ�cookie��������������ʱ��Ϊ0
		//����cookie
		Cookie cookie = new Cookie("time","");
		//pathһ��
		cookie.setPath(request.getContextPath()+"/");
		//��������ʱ��Ϊ0
		cookie.setMaxAge(0);
		//��cookie���͵������
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
