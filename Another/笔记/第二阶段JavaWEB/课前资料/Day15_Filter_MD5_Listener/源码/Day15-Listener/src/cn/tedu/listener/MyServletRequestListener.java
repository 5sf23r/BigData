package cn.tedu.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestҪ���N���ˡ�����");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request�������ˡ�����");
	}

}
