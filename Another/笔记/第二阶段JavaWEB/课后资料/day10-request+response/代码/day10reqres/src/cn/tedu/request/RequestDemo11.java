package cn.tedu.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 作为域对象使用：
 * 		向域中添加数据
 * 		请求转发给首页展示。
 * @author Administrator
 *
 */
public class RequestDemo11 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = "lishuai";
		int age = 19;
		String addr = "bj";
		String gender = "男";
		//第一步添加数据到request域中
		request.setAttribute("username", username);
		request.setAttribute("age", age);
		request.setAttribute("addr", addr);
		request.setAttribute("gender", gender);
		//添加完数据后，请求转发到首页
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
