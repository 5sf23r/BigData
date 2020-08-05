package com.easymall.utils;
/**
 * 工具类
 * @author admin
 *
 */
public class WebUtils {
	private WebUtils(){
		
	}
	//非空校验
	public static boolean isNull(String str){
		return (str == null || str.trim().equals(""));
	}
}
