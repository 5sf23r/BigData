package cn.tedu.log4j;

import org.apache.log4j.Logger;

public class Demo1 {
	
	public static Logger logger = Logger.getLogger(Demo1.class);
	public static void main(String[] args) {
		logger.debug("���Լ���");
		logger.info("��ͨ��־��Ϣ");
		logger.warn("������־��Ϣ");
		logger.error("������־��Ϣ");
		logger.fatal("��������־��Ϣ");
	}

}
