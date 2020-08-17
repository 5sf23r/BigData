package cn.commandoptionesc.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassDemo3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<String> c1z = String.class;
        String str = "abcdefg";

        ////获取String中charAt方法
        //Method m = c1z.getDeclaredMethod("charAt",int.class);
        ////执行charAt方法
        ////等价于：char c = str.charAt(3);
        //char c = (char) m.invoke(str,3);
        //System.out.println(c);

        //m代表getChars(char[],int)方法
        Method m = c1z.getDeclaredMethod("getChars", char[].class, int.class);
        //暴力破解 - 可以打破权限修饰符的范围
        m.setAccessible(true);
        char[] cs = new char[10];
        //等价于：str.getChars(cs,0);
        m.invoke(str,cs,0);
    }
}
