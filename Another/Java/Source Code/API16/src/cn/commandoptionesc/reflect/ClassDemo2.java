package cn.commandoptionesc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassDemo2 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //c1z1表示String类的字节码
        Class<String> c1z1 = String.class;
        //创建对象
        //等价于：String str = new String();
        //要求这个类中必须提供无参构造
        String str = c1z1.newInstance();
        System.out.println(str);

        //c1z2表示Integer类的字节码
        Class<Integer> c1z2 = Integer.class;
        //Integer in = c1z2.newInstance();
        //System.out.println(in);
        //如果需要利用含参构造来创建对象，那么需要先获取对应的构造函数
        Constructor<Integer> c = c1z2.getDeclaredConstructor(int.class);
        //执行这个构造函数来创建对象
        //等价于：Integer in = new Integer(5);
        Integer in = c.newInstance(5);
        System.out.println(c);
    }
}
