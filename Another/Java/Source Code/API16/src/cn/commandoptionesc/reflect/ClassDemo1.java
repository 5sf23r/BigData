package cn.commandoptionesc.reflect;

import java.util.List;
import java.util.Scanner;

public class ClassDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {

        //获取Class对象
        //方式一：通过类型.class的方式获取
        //c1z1表示String类对应的字节码
        Class<String> c1z1 = String.class;
        System.out.println(c1z1);
        //c1z2表示List接口对应的字节码
        Class<List> c1z2 = List.class;
        System.out.println(c1z1);
        //c1z3表示double基本类型对应的字节码
        Class c1z3 = double.class;
        System.out.println(c1z3);

        //方式二：通过对象.getClass(）来获取
        Object o = "abc";
        Class<String> c1z4 = (Class<String>) o.getClass();
        System.out.println(c1z4);

        //方式三：Class.forName
        //表示获取Scanner类型对应的字节码
        Class<Scanner> c1z5 = (Class< Scanner>) Class.forName("java.util.Scanner");
        System.out.println(c1z5);
    }
}
