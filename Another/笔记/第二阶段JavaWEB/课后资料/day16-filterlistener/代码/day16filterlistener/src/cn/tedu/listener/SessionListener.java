package cn.tedu.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//session对象创建
public class SessionListener implements HttpSessionListener {

	//session对象创建触发的方法
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session对象被创建"+se.getSession());
	}

	//session对象销毁触发的方法
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session对象被销毁"+se.getSession());

	}

}
