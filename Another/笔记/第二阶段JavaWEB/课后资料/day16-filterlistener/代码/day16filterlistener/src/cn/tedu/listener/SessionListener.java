package cn.tedu.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//session���󴴽�
public class SessionListener implements HttpSessionListener {

	//session���󴴽������ķ���
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session���󱻴���"+se.getSession());
	}

	//session�������ٴ����ķ���
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session��������"+se.getSession());

	}

}
