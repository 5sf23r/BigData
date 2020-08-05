package cn.tedu.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo8 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取到用户的个人资料
		String name = "张飞";
		int age = 18;
		String nickname = "飞飞";
		String addr = "河北";
		
		//2.将数据保存进request域中
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("nickname", nickname);
		request.setAttribute("addr", addr);
		
		//3.通过转发将数据带到jsp页面中
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
