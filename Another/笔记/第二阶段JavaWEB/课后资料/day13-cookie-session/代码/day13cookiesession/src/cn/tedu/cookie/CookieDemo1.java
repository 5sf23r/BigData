package cn.tedu.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//在浏览器中回显用户上次访问页面的时间
public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		//产生一个时间值
		Date date = new Date();
		String time = date.toLocaleString();
		//实现cookie。
		//1.设置setcookie响应头
		response.setHeader("set-cookie", time);
		//2.获取一个请求头cookie
		String cookie = request.getHeader("cookie");
		
		//如果用户是第一次访问当前页面，则在浏览器中没有cookie请求头，
		//所以无法获取到上次访问的时间
		if(cookie == null){
			response.getWriter().write("您是初次访问这个页面");
			
		}else{
			//如果不是初次访问，
			//则在cookie请求中会读取浏览器中保留的set-cookie响应头中上次访问时间
			response.getWriter().write("您上次访问本页面的时间是："+cookie);
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
