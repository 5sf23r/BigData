package cn.tedu.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session�������ˡ�����"+se.getSession());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionҪ���N���ˡ�����"+se.getSession());
	}

}
