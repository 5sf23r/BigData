package cn.tedu.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MySCAtrrListener implements ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("���Ա�����sc��"+scab.getName()+"~"+scab.getValue());
	}

	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("���Ա��Ƴ���sc��"+scab.getName()+"~"+scab.getValue());
	}

	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("���Ա��滻��sc��"+scab.getName()+"~"+scab.getValue()+"~"+scab.getServletContext().getAttribute(scab.getName()));
	}

}
