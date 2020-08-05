package cn.tedu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//ServletContext对象的监听器
public class SCListener implements ServletContextListener {

	//对象创建时候触发的方法
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext对象已经创建"+sce.getServletContext());

	}
	//对象销毁的时候触发的方法
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletConxt对象已经销毁"+sce.getServletContext());
		
	}

}
