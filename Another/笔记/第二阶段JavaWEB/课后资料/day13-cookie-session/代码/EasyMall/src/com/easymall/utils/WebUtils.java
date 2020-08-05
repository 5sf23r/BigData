package com.easymall.utils;
/**
 * 判断是否为空的工具类
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
