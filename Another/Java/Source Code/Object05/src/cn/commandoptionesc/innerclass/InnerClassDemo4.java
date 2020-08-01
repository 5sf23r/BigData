package cn.commandoptionesc.innerclass;

public class InnerClassDemo4 {

    //当匿名内部类定义在类中，使用规则和成员内部类一致
    Pet p = new Pet(){

    };
    public static void main(String[] args) {

        //匿名内部类
        //匿名内部类本质上是继承了new的类
        //当匿名内部类定义在方法中的时候，使用规则就喝方法内部类一致
        Animal a = new Animal() {
            @Override
            public void eat() {

            }
        };

        //匿名内部类本质上是实现了这个接口
        Pet p = new Pet() {
        };

        //只要一个类可以被继承，那么这个类就可以存在匿名内部类形式
        Cat c = new Cat(){

        };

        /*
        //最终类不能产生匿名内部类
        //Cannot inherit from final 'cn.commandoptionesc.innerclass.Dog'
        Dog d = new Dog(){
        };
        */

    }
}

abstract class Animal{
    public abstract void eat();
}

interface Pet{}

class Cat{}

final class Dog{}