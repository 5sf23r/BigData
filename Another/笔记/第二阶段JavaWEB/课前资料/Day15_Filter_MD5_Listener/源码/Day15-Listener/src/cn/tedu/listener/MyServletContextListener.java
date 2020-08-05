package cn.tedu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext被初始化了。。。"+sce.getServletContext());
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext要被销毁了。。。"+sce.getServletContext());
	}

}
