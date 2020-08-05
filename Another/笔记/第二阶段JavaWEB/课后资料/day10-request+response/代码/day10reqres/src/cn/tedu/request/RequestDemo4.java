package cn.tedu.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 请求转发实现
 * 	与RequestDemo5一组
 * @author Administrator
 *
 */
public class RequestDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//请求转发
		//获取一个调度器
		RequestDispatcher rd = request.getRequestDispatcher("/servlet/RequestDemo5");
		//利用调度器实现请求转发
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
