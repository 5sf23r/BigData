package cn.tedu.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User  implements HttpSessionBindingListener{
	private String username;
	private int age;
	
	
	
	public User(String username, int age) {
		super();
		this.username = username;
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//将当前javabea对象加入session域中时触发
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("对象加入session域"+event.getName());
	}
	
	//将当前javabea对象移除session域中时触发
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("对象移除session域"+event.getName());
		
	}
	

}
