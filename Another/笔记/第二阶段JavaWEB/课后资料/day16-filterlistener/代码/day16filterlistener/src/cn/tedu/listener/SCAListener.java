package cn.tedu.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class SCAListener implements ServletContextAttributeListener {

	//��������Դ����ķ���
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("��ǰ�������Ѿ����뵽ServletContext��"+scab.getName());
	}

	//ɾ�������Դ����ķ���
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("��ǰ�������Ѿ����Ƴ�ServletContext��"+scab.getName());

	}

	//�滻�����Դ����ķ���
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("��ǰ�������Ѿ����滻ServletContext��"+scab.getName()+scab.getValue());

	}

}
