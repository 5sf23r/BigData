package cn.commandoptionesc.code;

import javax.swing.plaf.basic.BasicButtonListener;

public class ConstructorCodeDemo {
    public static void main(String[] args) {
        new Baby();
        new Baby("helen");
    }
}

//定义一个类表示婴儿
class Baby{
    String name;

    //在类中用{}括起来的代码称之为构造代码块或者叫初始化代码块
    //无论调用哪个构造方法，这个代码块都会执行
    //构造代码块是先于构造方法执行的
    {
        this.cry();
        this.eat();
    }

    public Baby(){
    }

    public Baby(String name){
        System.out.println("~~~~~~~~~~");
        this.name = name;
    }

    public void cry(){
        System.out.println("这个婴儿在哭");
    }

    public void eat() {
        System.out.println("这个婴儿在吃");
    }
}
