package cn.commandoptionesc.extendsx;
public class ExtendsDemo2{
    public static void main(String[] args){
        new Pig().eat();
    }
}
//动物类
class Animal{
    public Animal(){
        
    }
    public Animal(int age){
        
    }
    //方法
    public void eat(){
        System.out.println("在吃东西...");
    }

    public void sleep(){
        System.out.println("在睡觉...");
    }
}
class Pig extends Animal{
    //父类对象优先子类对象存在
    //子类所有的构造方法都要去调用父类无参构造（默认）
    public Pig(){
        //super()----super语句，在子类中调用父类的构造方法
        //子类所有的构造方法都含有super()
        //本构造方法中有了其他形式的super()就没有super（）
        //super(1);
    }
    public Pig(int age){
        //super()
        //this();
        super(age);
    }
    public void eat(){
        System.out.println("在呼呼呼的吃...");
        System.out.println("慢慢的吃饱了...");
        System.out.println("吃饱了就想睡觉...");
        //父类方法
        //非静态的方法可以通过对象调用
        //super.sleep();------代表父类的对象调用sleep()方法
        super.sleep();
        sleep();
    }
}

