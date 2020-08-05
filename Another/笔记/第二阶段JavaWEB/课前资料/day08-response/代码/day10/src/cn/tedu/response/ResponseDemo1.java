package cn.tedu.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * response����һ: ��ͻ��˷�������
 */
public class ResponseDemo1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//getOutputStream()
		//response.getOutputStream().write("aaa".getBytes());
		
		//��������ָ��ʹ��utf-8
		//response.getOutputStream().write("�й�".getBytes("utf-8"));
		
		//֪ͨ�����ʹ��utf-8����������
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		//==========================================
		
		//getWriter()
		
		//֪ͨ������ʹ��utf-8����������
		//response.setCharacterEncoding("utf-8");
		
		//֪ͨ�����Ҳʹ��utf-8����������
		response.setContentType("text/html;charset=utf-8");
		
		//response.getOutputStream().write("�й�".getBytes("utf-8"));
		response.getWriter().write("�й�");//iso8859-1
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
