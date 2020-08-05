package cn.tedu.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request要被銷毀了。。。");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request被創建了。。。");
	}

}
