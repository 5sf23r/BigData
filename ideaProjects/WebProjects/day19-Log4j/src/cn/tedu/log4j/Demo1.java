package cn.tedu.log4j;

import org.apache.log4j.Logger;

public class Demo1 {
	
	public static Logger logger = Logger.getLogger(Demo1.class);
	public static void main(String[] args) {
		logger.debug("调试级别");
		logger.info("普通日志信息");
		logger.warn("警告日志信息");
		logger.error("错误日志信息");
		logger.fatal("致命的日志信息");
	}

}
