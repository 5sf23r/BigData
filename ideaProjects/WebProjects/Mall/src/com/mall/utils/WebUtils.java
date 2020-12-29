package com.mall.utils;

import java.io.UnsupportedEncodingException;

public class WebUtils {
    /*因为是公共的资源方法，所有做好设计成静态的方法*/
    private WebUtils(){
        //私有化，别人不能new
    }
    /*1. 非空校验*/
    public static boolean isNull(String value){

        return value == null || "".equals(value.trim()) ? true:false;
    }
    /*2. 对字符集进行正确的编码，防止乱码出现*/
    public static String encoding(String value,String character){
        try {
            if (value != null) {
                value = new String(value.getBytes("ISO-8859-1"),character);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
