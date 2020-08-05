package cn.tedu.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 取出购物车中的商品, 为其结算
 */
public class PayServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//1.获取session
		HttpSession session = request.getSession(false);
		if(session != null){
			String prod = (String) session.getAttribute("prod");
			response.getWriter().write("成功为[ "+prod+" ]商品结算, 支付10000.00$...");
		}else{
			response.getWriter().write("您还没有将任何商品加入购物车...");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
