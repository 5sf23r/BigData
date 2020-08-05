package cn.tedu.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 控制缓存：
 * 	不使用缓存
 * @author Administrator
 *
 */
public class ResponseDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//不使用缓存
	/*	response.setDateHeader("Expires", -1);//1970-01-01
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-control", "no-cache");*/
		//使用缓存
		response.setHeader("Cache-control", "max-age=3");
		response.setDateHeader("Expires", System.currentTimeMillis()+1000*60*60*24);
		
		Date date = new Date();
		String time = date.toLocaleString();
		response.getWriter().write("time:"+time);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
