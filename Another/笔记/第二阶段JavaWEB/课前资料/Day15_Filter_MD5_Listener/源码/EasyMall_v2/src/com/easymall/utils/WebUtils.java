package com.easymall.utils;
/**
 * ������
 * @author admin
 *
 */
public class WebUtils {
	private WebUtils(){
		
	}
	//�ǿ�У��
	public static boolean isNull(String str){
		return (str == null || str.trim().equals(""));
	}
}
