package cn.tedu.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//cookie����ʱ������Ч·������
public class CookieDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Date date = new Date();
		String time = date.toLocaleString();
		//����cookie
		Cookie cookie = new Cookie("time",time);
		//�޸�cookie����ʱ������Ч·��
		//����cookie����ʱ��������ֵΪ��λ��
		cookie.setMaxAge(60*60*24);
		//����·��
		//�޸�ΪwebӦ�õ�����·��
		//�����ȱʡwebӦ�ã�����request.getContextPath�л�ȡ��һ���յķ���ֵ��
		//���ֵ������ΪsetPath��ֵ����Ҫ��������һ��"/"���������ǵ�ǰwebӦ�õ�·����
		cookie.setPath(request.getContextPath()+"/");
		//����cookie
		response.addCookie(cookie);
		Cookie timeC = null;
		//��ȡcookie
		Cookie[] cs = request.getCookies();
		if(cs != null){
			for(Cookie c:cs){
				if("time".equals(c.getName())){
					timeC = c;
				}
			}
		}
		if(timeC != null){
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
