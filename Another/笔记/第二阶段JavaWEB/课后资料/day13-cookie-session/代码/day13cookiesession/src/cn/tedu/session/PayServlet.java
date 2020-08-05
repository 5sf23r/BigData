package cn.tedu.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//付款servlet
//将商品计算价格并发送到浏览器
public class PayServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//获取session对象
		HttpSession session = request.getSession();
		//获取session域中的属性
		String prod = (String) session.getAttribute("prod");
		if(prod == null){
			
			response.getWriter().write("您还未选择任何商品");
		}else{
			
			//向浏览器提示付款信息；
			response.getWriter().write("已付款商品【"+prod+"】，价格￥10000000");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
