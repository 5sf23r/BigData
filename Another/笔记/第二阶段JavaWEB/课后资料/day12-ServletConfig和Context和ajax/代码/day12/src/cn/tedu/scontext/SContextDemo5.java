package cn.tedu.scontext;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//路径问题
public class SContextDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//相对路径
//		String path = "config.properties";
		//绝对路径
//		String path = "/config.properties";
//		String path = "D:\\software\\apache-tomcat-7.0.62\\webapps\\day12\\WEB-INF\\web.xml";
		/*ServletContext sc = this.getServletContext();
		String path = sc.getRealPath("WEB-INF\\web.xml");*/
		
		//类加载器获取路径
		String path = SContextDemo5.class.getClassLoader().getResource("config.properties").getPath();
		File file = new File(path);
		System.out.println(file.getAbsolutePath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
