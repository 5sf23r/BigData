package cn.tedu.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SCAListener implements ServletContextAttributeListener {

	//添加域属性触发的方法
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("当前域属性已经加入到ServletContext中"+scab.getName());
	}

	//删除与属性触发的方法
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("当前域属性已经被移除ServletContext中"+scab.getName());

	}

	//替换域属性出发的方法
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("当前域属性已经被替换ServletContext中"+scab.getName()+scab.getValue());

	}

}
