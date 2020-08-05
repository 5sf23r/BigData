package cn.tedu.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 将商品加入购物车
 */
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取商品信息
		String prod = request.getParameter("prod");
		prod = new String(prod.getBytes("iso8859-1"), "utf-8");
		
		//2.获取session对象
		HttpSession session = request.getSession();//如果有session直接拿过用, 如果没有session就创建一个新的拿过来
		session.setAttribute("prod", prod);
		
		response.setContentType("text/html;charset=utf-8");
		
		//设置保存sessionid的cookie的最大存活时间.
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setPath(request.getContextPath()+"/");
		cookie.setMaxAge(30*60);
		response.addCookie(cookie);
		
		//3.做出回应
		response.getWriter().write("恭喜您, 成功将[ "+prod+" ]商品加入了购物车...");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
