package cn.tedu.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {
	
	//request销毁时调用的方法
	public void requestDestroyed(ServletRequestEvent sre) {
		
		System.out.println("请求已经销毁"+sre.getServletRequest());;
	}

	//request创建时调用的方法
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("请求已经创建"+sre.getServletRequest());;
	}

}
