package com.easymall.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
//监听EasyMall应用启动和销毁的过程
public class MyServletContextListener implements ServletContextListener {
	public static Logger logger = Logger.getLogger(MyServletContextListener.class);
	//ServletContext对象产生
	public void contextInitialized(ServletContextEvent sce) {
//		System.out.println("EasyMall应用启动.");
		logger.info("EasyMall应用启动.");
	}

	//ServletContext对象销毁
	public void contextDestroyed(ServletContextEvent sce) {
//		System.out.println("EasyMall应用销毁.");
		logger.info("EasyMall应用销毁.");
		
	}

}
