package cn.tedu.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {
	
	//request����ʱ���õķ���
	public void requestDestroyed(ServletRequestEvent sre) {
		
		System.out.println("�����Ѿ�����"+sre.getServletRequest());;
	}

	//request����ʱ���õķ���
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("�����Ѿ�����"+sre.getServletRequest());;
	}

}
