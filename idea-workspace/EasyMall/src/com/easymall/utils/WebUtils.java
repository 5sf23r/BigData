package com.easymall.utils;

/**
 * 判断是否为空的工具类
 */
public class WebUtils {
    private WebUtils() {

    }
    public static boolean isNULL(String name){
        //return name.trim().equals("") || name == null;
        //如果用户名为空的话 null.trim()...就会造成空指针异常
        //""双引号放在前面可以避免
        return "".equals(name.trim()) || name == null;
    }
}
