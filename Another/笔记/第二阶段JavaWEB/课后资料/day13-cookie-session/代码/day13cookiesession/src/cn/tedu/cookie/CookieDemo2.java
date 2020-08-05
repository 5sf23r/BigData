package cn.tedu.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�û��ϴη���ҳ���ʱ�䡣
//Cookie��ʵ��
public class CookieDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//����time
		Date date = new Date();
		String time = date.toLocaleString();
		//����cookie
		Cookie cookie = new Cookie("time",time);
		//����cookie�������
		response.addCookie(cookie);
		//request.getCookie����ȡ��ȫ��cookie���α��һ��cookie����
		//ÿһ��cookie���󱣴���Ե�cookieName cookieValue
		//���ҽ���Щ�������һ��cookie�����б��棬�������
		Cookie[] cs =  request.getCookies();
		
		Cookie timeC = null;
		//���ڳ���û��cookieͷ������cs����Ϊnull�������������ָ���쳣����
		if(cs != null){
			for(Cookie c:cs){
				if("time".equals(c.getName())){
					timeC = c;
				}
			}
		}
		
		if(timeC != null){
			//timeC.getValue()��ȡcookie�е�valueʱ��ֵ��
			response.getWriter().write("���ϴη���ҳ���ʱ��Ϊ��"+timeC.getValue());
		}else{
			response.getWriter().write("���ǳ��η��ʱ�ҳ��");
			
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
