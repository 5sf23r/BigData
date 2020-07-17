package cn.commandoptionesc.duotai;
public class DTDemo{
    public static void main(String[] args){
        //告诉别人要养宠物，宠物是猫
        //声明类---父类，实际创建类---子类 向上造型
        Pet p=new Cat();

        //调用方法
        //向上造型创建的对象调用方法执行，由子类具体执行
        p.eat();

        //向上造型创建的对象可以调用哪些方法看父类
        // p.play();
        p.sleep();
        n(p);
        n(new Dog());
        n(new Cat());
    }
    //参数的统一
    //只要等到运行时期才能明确向上造型的对象由谁实际创建
    public static void n(Pet p){
        p.eat();
    }
}
//宠物类
class Pet{
    //方法
    public void eat(){
        System.out.println("在吃东西...");
    }
    /* public void play(){
        System.out.println();
        }*/
    public void sleep(){
        System.out.println("在睡觉...");
    }
} 

//猫
class Cat extends Pet{
    
    //重写方法
    public void eat(){
        System.out.println("一点一点的吃...");
    }

    public void play(){
        System.out.println("在舔爪子...");
    }
}

//狗
class Dog extends Pet{
    
    //重写
    public void eat(){
        System.out.println("大口大口的吃...");
    }
    public void bark(){
        System.out.println("在汪汪汪的叫...");
    }
}
