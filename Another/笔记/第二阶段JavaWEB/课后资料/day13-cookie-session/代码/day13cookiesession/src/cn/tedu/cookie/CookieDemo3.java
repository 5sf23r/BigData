package cn.tedu.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//cookie生命时长、有效路径设置
public class CookieDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Date date = new Date();
		String time = date.toLocaleString();
		//创建cookie
		Cookie cookie = new Cookie("time",time);
		//修改cookie生命时长、有效路径
		//设置cookie生命时长（以秒值为单位）
		cookie.setMaxAge(60*60*24);
		//设置路径
		//修改为web应用的虚拟路径
		//如果是缺省web应用，则在request.getContextPath中获取到一个空的返回值。
		//这个值不能作为setPath的值，需要在其后加上一个"/"，来表明是当前web应用的路径。
		cookie.setPath(request.getContextPath()+"/");
		//发送cookie
		response.addCookie(cookie);
		Cookie timeC = null;
		//获取cookie
		Cookie[] cs = request.getCookies();
		if(cs != null){
			for(Cookie c:cs){
				if("time".equals(c.getName())){
					timeC = c;
				}
			}
		}
		if(timeC != null){
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
