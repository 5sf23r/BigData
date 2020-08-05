package cn.tedu.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��������л����û��ϴη���ҳ���ʱ��
public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		//����һ��ʱ��ֵ
		Date date = new Date();
		String time = date.toLocaleString();
		//ʵ��cookie��
		//1.����setcookie��Ӧͷ
		response.setHeader("set-cookie", time);
		//2.��ȡһ������ͷcookie
		String cookie = request.getHeader("cookie");
		
		//����û��ǵ�һ�η��ʵ�ǰҳ�棬�����������û��cookie����ͷ��
		//�����޷���ȡ���ϴη��ʵ�ʱ��
		if(cookie == null){
			response.getWriter().write("���ǳ��η������ҳ��");
			
		}else{
			//������ǳ��η��ʣ�
			//����cookie�����л��ȡ������б�����set-cookie��Ӧͷ���ϴη���ʱ��
			response.getWriter().write("���ϴη��ʱ�ҳ���ʱ���ǣ�"+cookie);
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
