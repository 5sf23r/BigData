package cn.commandoptionesc.staticx;

public class StaticDemo3 {
    public static void main(String[] args) {
        //静态代码块只在类加载的时候执行一次，因为累值加载一次，所以静态代码块也只执行一次
        new A();
        new A();
    }
}

class A {

    //静态代码块
    static{
        System.out.println("A");
    }
}
