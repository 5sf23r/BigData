package cn.tedu.scontext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//1.��ȡServletContext����
public class SContextDemo1 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡServletContext����
		ServletContext sc = this.getServletConfig().getServletContext();
		//��ȡwebӦ�õ�������Ϣ
		String user = sc.getInitParameter("user");
		System.out.println("user:"+user);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
