package com.easymall.utils;
/**
 * �ж��Ƿ�Ϊ�յĹ�����
 * @author Administrator
 *
 */
public class WebUtils {
	private WebUtils(){
		
	}
	public static boolean isNull(String name){
		return "".equals(name.trim()) || name == null;
	}

}
