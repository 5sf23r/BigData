package com.easymall.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
//����EasyMallӦ�����������ٵĹ���
public class MyServletContextListener implements ServletContextListener {
	public static Logger logger = Logger.getLogger(MyServletContextListener.class);
	//ServletContext�������
	public void contextInitialized(ServletContextEvent sce) {
//		System.out.println("EasyMallӦ������.");
		logger.info("EasyMallӦ������.");
	}

	//ServletContext��������
	public void contextDestroyed(ServletContextEvent sce) {
//		System.out.println("EasyMallӦ������.");
		logger.info("EasyMallӦ������.");
		
	}

}
