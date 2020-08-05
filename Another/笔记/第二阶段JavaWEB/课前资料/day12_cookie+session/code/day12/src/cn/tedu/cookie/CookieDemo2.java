package cn.tedu.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����ҳ����ʾ�ϴη���ʱ��
 *
 */
public class CookieDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.��������
		response.setContentType("text/html;charset=utf-8");
		
		//1.��ȡʱ���ַ���
		String dateStr1 = new Date().toLocaleString();
		
		//2.����Cookie
		Cookie cookie  = new Cookie("time", dateStr1);
		
		//����Cookie���������ʱ��, ��Cookie��������ʱ�ļ�����
		cookie.setMaxAge(3600);//��λ����
		
		//����Cookie��·��
		//cookie.setPath("/day12");
		cookie.setPath(request.getContextPath()+"/");
		
		//3.����Cookie
		response.addCookie(cookie);
		//==============================
		
		//4.��ȡ�ϴη���ʱ��
		//5.��ȡCookie
		Cookie timeC = null;
		Cookie[] cs = request.getCookies();
		if(cs != null){
			for(Cookie c : cs){
				if("time".equals(c.getName())){
					timeC = c;
				}
			}
		}
		
		//6.��ӡʱ��
		if(timeC != null){
			response.getWriter().write("���ϴη��ʵ�ʱ��: "+timeC.getValue());
		}else{
			response.getWriter().write("���ǵ�һ�η��ʱ���վ!");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
