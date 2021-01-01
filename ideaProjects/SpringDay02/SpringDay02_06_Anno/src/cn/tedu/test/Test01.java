package cn.tedu.test;

import org.junit.Test;

import java.util.Date;

class Person {
    @Deprecated
    public void eat(){
        System.out.println("吃..");
    }
    public void say(){
        System.out.println("说..");
    }
    public void est2(){
        System.out.println("吃2..");
    }
}

/**
 * jdk自带的注解
 */

class Teacher extends Person{
    @Override
    public void say(){
        System.out.println("一本正经的说..");
    }
}

public class Test01{
    @Test
    @SuppressWarnings("deprecation")
    public void test01() {
        Teacher t = new Teacher();
        t.eat();
        t.say();
        new Date().toLocaleString();
    }
}
