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

	//����ǰjavabean�Ķ�������session���ۻ�ʱ�ᴥ���˷���
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("��ǰuserbean����session���ۻ��ˡ���");
	}
	
	//����ǰjavabean�Ķ�������session���ʱ�ᴥ���˷���
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("��ǰuserbean����session����ˡ���");
	}
	
	//����ǰjavabean�Ķ��󱻴���sessionʱ����
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("��ǰuserbean ��֪���Լ�������session�ˡ���");
	}
	//����ǰjavabean�Ķ����Ƴ���sessionʱ����
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("��ǰuserbean ��֪���Լ����Ƴ���session�ˡ���");
		
	}
}
