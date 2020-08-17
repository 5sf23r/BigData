package cn.commandoptionesc.reflect;

import java.lang.reflect.Field;

public class ClassDemo4 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Class<String> c1z = String.class;
        String str = "hello";
        //f代表了String类中的hash属性
        Field f = c1z.getDeclaredField("hash");
        f.setAccessible(true);
        //改变属性的值
        //等价于：str.hash = 135;
        f.set(str,135);
        System.out.println(f.get(str));
    }
}
