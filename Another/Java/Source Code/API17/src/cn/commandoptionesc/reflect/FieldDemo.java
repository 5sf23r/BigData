package cn.commandoptionesc.reflect;

import java.lang.reflect.Field;

public class FieldDemo {
    public static void main(String[] args) throws NoSuchFieldException {

        Class<String> c1z = String.class;
        Field f = c1z.getDeclaredField("hash");

        //获取属性所在的类的类型
        System.out.println(f.getDeclaringClass());

        //获取属性的声明类型
        System.out.println(f.getType());
    }
}
