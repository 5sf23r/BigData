package cn.tedu.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//用户上次访问页面的时间。
//Cookie类实现
public class CookieDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//创建time
		Date date = new Date();
		String time = date.toLocaleString();
		//创建cookie
		Cookie cookie = new Cookie("time",time);
		//发送cookie到浏览器
		response.addCookie(cookie);
		//request.getCookie将获取的全部cookie依次变成一个cookie对象
		//每一个cookie对象保存各自的cookieName cookieValue
		//并且将这些对象放入一个cookie数组中保存，方便管理。
		Cookie[] cs =  request.getCookies();
		
		Cookie timeC = null;
		//由于初次没有cookie头，所以cs数组为null，遍历会产生空指针异常。、
		if(cs != null){
			for(Cookie c:cs){
				if("time".equals(c.getName())){
					timeC = c;
				}
			}
		}
		
		if(timeC != null){
			//timeC.getValue()获取cookie中的value时间值。
			response.getWriter().write("您上次访问页面的时间为："+timeC.getValue());
		}else{
			response.getWriter().write("您是初次访问本页面");
			
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
