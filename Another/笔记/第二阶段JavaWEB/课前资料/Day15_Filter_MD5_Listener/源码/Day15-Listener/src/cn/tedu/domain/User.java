package cn.tedu.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements Serializable, HttpSessionBindingListener,HttpSessionActivationListener {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	//当当前javabean的对象随着session被钝化时会触发此方法
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("当前userbean随着session被钝化了。。");
	}
	
	//当当前javabean的对象随着session被活化时会触发此方法
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("当前userbean随着session被活化了。。");
	}
	
	//当当前javabean的对象被存入session时触发
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("当前userbean 感知到自己被加入session了。。");
	}
	//当当前javabean的对象被移除出session时触发
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("当前userbean 感知到自己被移除出session了。。");
		
	}
}
