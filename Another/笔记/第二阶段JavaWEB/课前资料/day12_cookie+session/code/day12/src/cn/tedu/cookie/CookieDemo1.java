package cn.tedu.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 在网页中显示上次访问时间
 */
public class CookieDemo1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决乱码
		response.setContentType("text/html;charset=utf-8");
		
		//获取时间字符串
		String dateStr = new Date().toLocaleString();
		response.setHeader("Set-Cookie", "time="+dateStr);
		
		//获取上次访问时间
		String dateStr2 = request.getHeader("cookie");
		response.getWriter().write("您上次访问的时间为: "+dateStr2);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
