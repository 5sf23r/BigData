package cn.tedu;

import java.lang.reflect.Method;

class Person{
    public void rap(String str){
        System.out.println("唱跳rap.."+str);
    }
}

public class Test03 {
    public static void main(String[] args) throws Exception {
        Person cxk = new Person();
        //p.rap();

        Class clz = cxk.getClass();
        Method m = clz.getMethod("rap",String.class);
        m.invoke(cxk,"要要要切克闹，煎饼果子来一套");

    }
}
