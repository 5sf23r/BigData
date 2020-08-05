package cn.tedu.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session被創建了。。。"+se.getSession());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session要被銷毀了。。。"+se.getSession());
	}

}
