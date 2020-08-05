package cn.tedu.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//购物车servlet
//商品添加的操作
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String prod = request.getParameter("prod");
		prod = new String(prod.getBytes("iso8859-1"),"utf-8");
		
		//向session域中添加数据 ---在当前会话范围内实现商品数据的共享。
		//创建session
		HttpSession session = request.getSession();
		session.setAttribute("prod", prod);
		//创建一个JSESSIONID的cookie ，将session保存在本地，
		//使浏览器多次关闭打开都能够获取到同一个session
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*60*24);
		cookie.setPath(request.getContextPath()+"/");
		response.addCookie(cookie);
		
		//向页面显示商品添加信息。
		response.getWriter().write("已经将商品【"+prod+"】加入购物车");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
	
	
	
	
	
	
	
	
	

}
