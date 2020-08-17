package cn.commandoptionesc.reflect;

import java.lang.reflect.Method;

public class MethodDemo {
    public static void main(String[] args) throws NoSuchMethodException {

        Class<String> c1z = String.class;

        //获取String中charAt(int)方法
        Method m = c1z.getDeclaredMethod("charAt",int.class);

        //获取String中getByte(String)方法
        Method n = c1z.getDeclaredMethod("getBytes",String.class);

        //获取这个方法锁对应的类
        System.out.println(m.getDeclaringClass());
        System.out.println(n.getDeclaringClass());

        //获取这个方法抛出的异常
        Class<Exception>[] es = (Class<Exception>[]) m.getExceptionTypes();
        for(Class<Exception> e:es){
            System.out.println(e);
        }

        //
        Class<?>[] ps = m.getParameterTypes();
        for(Class<?> p:ps){
            System.out.println(p);
        }

        //获取方法的返回值类型
        Class<?> r = m.getReturnType();
        System.out.println(r);
    }
}
