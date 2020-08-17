package cn.commandoptionesc.reflect;

import java.lang.reflect.Constructor;

public class ClassDemo5 {
    public static void main(String[] args) throws NoSuchMethodException {

        Class<String> c1z = String.class;
        ////获取String类中所有的构造方法
        //Constructor<String>[] cs = (Constructor<String>[]) c1z.getDeclaredConstructors();
        //for(Constructor<String> c:cs){
        //    System.out.println(c);
        //}

        //获取String类实现的接口
        Class<?>[] is = c1z.getInterfaces();
        for(Class<?> i:is){
            System.out.println(i);
        }

        //获取类的修饰符
        int m = c1z.getModifiers();
        System.out.println(m);

        //获取类的全路径名
        System.out.println(c1z.getName());
        //获取类名
        System.out.println(c1z.getSimpleName());

        //获取包
        System.out.println(c1z.getPackage());

        //获取父类
        System.out.println(c1z.getSuperclass());
    }
}
