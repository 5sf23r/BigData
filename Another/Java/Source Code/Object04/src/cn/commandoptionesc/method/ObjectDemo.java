package cn.commandoptionesc.method;

public class ObjectDemo {
    public static void main(String[] args) {

        //用父类Pet生命对象，用子类创建对象 ---> 向上造型
        //向上造型创建对象，在编译的时候，并不会去检查具体子类
        //在编译的时候，首先发现Pet p所以确定这个对象是一个Pet对象
        //继续往后编译会检查后边要使用的类和前面生命的类是否有继承关系
        //Cat和Pet有继承关系，那么就编译通过，而此时并没有去检查具体是哪一个子类
        //编译的时候没有确定子类，也就不知道子类中具体有哪些方法
        //所以在使用的时候，就不允许调用子类中独有的方法
        //此时只允许调用父类中声明的方法
        Pet p = new Cat();
        //向上造型创建的喜爱那个在调用方法的时候调用的是子类中的方法
        p.eat();

        //向上造型创建的对象不能调用子类中独有的的方法
        //p.catchMouse();
    }
}

//定义一个类表示宠物
class Pet{
    public void eat(){
        System.out.println("在吃东西");
    }

}

//定义一个类表示猫
class Cat extends Pet{
    @Override
    public void eat() {
        System.out.println("这只猫在吃鱼");
    }

    public void catchMouse(){
        System.out.println("这只猫抓到了一直老鼠");
    }
}

//定义一个类表示狗
class Dog extends Pet{
    @Override
    public void eat() {
        System.out.println("这只狗再吃骨头");
    }

    public void bark(){
        System.out.println("这是狗在汪汪叫");
    }
}
