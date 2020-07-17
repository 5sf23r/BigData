package cn.commandoptionesc.staticx;
public class JTchuanjiang1{
    public static void main(String[] args){
        new Demo1();
        new Demo1();
    }
}
class Demo{
    static int a=10;
    //静态代码块
    static{
        System.out.println(a);
        System.out.println("这是父类静态代码块");
    }
    {
        System.out.println("这是父类初始化代码块");
    }
    public Demo(){
        System.out.println("这是父类构造方法");
    }
}
class Demo1 extends Demo{
    static int a=20;
    static{
        System.out.println(a);
        System.out.println("这是子类静态代码块");
    }
    {
        System.out.println("这是子类的初始化代码块");
    }
    public Demo1(){
        System.out.println("这是子类构造方法");
    }
}
