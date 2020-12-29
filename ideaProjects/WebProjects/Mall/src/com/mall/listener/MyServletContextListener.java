package com.mall.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


@javax.servlet.annotation.WebListener
public class MyServletContextListener implements ServletContextListener {
    public static Logger logger = Logger.getLogger(MyServletContextListener.class);

    @Override
    //ServletContext对象产生
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("Mall应用启动");
    }

    @Override
    //ServletContext对象销毁
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("Mall应用销毁");
    }
}
