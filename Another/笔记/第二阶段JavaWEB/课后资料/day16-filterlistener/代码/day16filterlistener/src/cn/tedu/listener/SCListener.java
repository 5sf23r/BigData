package cn.tedu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//ServletContext����ļ�����
public class SCListener implements ServletContextListener {

	//���󴴽�ʱ�򴥷��ķ���
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext�����Ѿ�����"+sce.getServletContext());

	}
	//�������ٵ�ʱ�򴥷��ķ���
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletConxt�����Ѿ�����"+sce.getServletContext());
		
	}

}
