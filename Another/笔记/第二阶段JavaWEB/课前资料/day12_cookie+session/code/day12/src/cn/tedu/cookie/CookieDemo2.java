package cn.tedu.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 在网页中显示上次访问时间
 *
 */
public class CookieDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.处理乱码
		response.setContentType("text/html;charset=utf-8");
		
		//1.获取时间字符串
		String dateStr1 = new Date().toLocaleString();
		
		//2.创建Cookie
		Cookie cookie  = new Cookie("time", dateStr1);
		
		//设置Cookie的最大生存时间, 让Cookie保存在临时文件夹中
		cookie.setMaxAge(3600);//单位是秒
		
		//设置Cookie的路径
		//cookie.setPath("/day12");
		cookie.setPath(request.getContextPath()+"/");
		
		//3.发送Cookie
		response.addCookie(cookie);
		//==============================
		
		//4.获取上次访问时间
		//5.获取Cookie
		Cookie timeC = null;
		Cookie[] cs = request.getCookies();
		if(cs != null){
			for(Cookie c : cs){
				if("time".equals(c.getName())){
					timeC = c;
				}
			}
		}
		
		//6.打印时间
		if(timeC != null){
			response.getWriter().write("您上次访问的时间: "+timeC.getValue());
		}else{
			response.getWriter().write("您是第一次访问本网站!");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
