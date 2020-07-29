package cn.commandoptionesc.extendsx;

public class ExtendsDemo {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.catchMouse();
        //通过继承，子类可以使用父类中一部分的方法和属性
        c.eat();
    }
}

//定义一个类表示宠物
//父类、基类、超类
class Pet{
    String color;

    public void eat(){

        System.out.println("在吃东西");
    }
}

//定义一个类表示猫
//利用extends关键字让Cat和Pet类产生了联系，这种联系称之为集成
//Cat类集成了Pet类
//子类、派生类
class Cat extends Pet{

    public void catchMouse(){

        System.out.println("这只猫抓住了一直老鼠");
    }
}

//定义一个类代表Dog
class Dog{

    public void bark(){

        System.out.println("这只狗在狂叫");
    }
}

//BlueCat是Cat类的直接子类，是Pet类的间接子类
class BlueCat extends Cat{

}