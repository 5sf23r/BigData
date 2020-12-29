package cn.tedu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class SCListener implements ServletContextListener {

    //到web应用启动时调用方法
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Day20已启动" +servletContextEvent.getServletContext());
    }
    //web应用被销毁时调用方法
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Day20已结束" +servletContextEvent.getServletContext());

    }
}
