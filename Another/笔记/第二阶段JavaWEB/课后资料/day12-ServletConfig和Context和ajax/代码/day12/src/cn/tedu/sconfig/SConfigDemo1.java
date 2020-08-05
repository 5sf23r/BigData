package cn.tedu.sconfig;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ServletConfig   可以获取servlet中的初始化配置信息
public class SConfigDemo1 extends HttpServlet {
	ServletConfig config = null;
	//1.获取ServletConfig对象
	//获取方式：通过init方法
	@Override
	public void init(ServletConfig config) throws ServletException {
		//如果config对象需要被doGet方法使用
		//则应该讲config对象提取成一个成员变量
		this.config = config;
//		super.init(config);
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从当前servlet身上获取指定名称的初始化配置信息。
		String username = config.getInitParameter("username");
		System.out.println("username:"+username);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
