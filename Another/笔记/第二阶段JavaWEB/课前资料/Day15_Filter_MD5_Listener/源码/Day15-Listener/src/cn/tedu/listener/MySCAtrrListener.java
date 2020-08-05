package cn.tedu.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MySCAtrrListener implements ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("属性被加入sc域"+scab.getName()+"~"+scab.getValue());
	}

	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("属性被移除出sc域"+scab.getName()+"~"+scab.getValue());
	}

	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("属性被替换在sc域"+scab.getName()+"~"+scab.getValue()+"~"+scab.getServletContext().getAttribute(scab.getName()));
	}

}
