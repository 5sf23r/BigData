package cn.commandoptionesc.staticx;

public class StaticDemo2 {
    public static void main(String[] args) {
        /*
        a调用m方法应该打印"B running"
        但打印的是"A runnimg"
        所以不是重写
        StaticMethodA a = new StaticMethodB();
        a.m();
         */
    }
}

class StaticMethodA{
    public static void m(){
        System.out.println("A running");
    }
}

class StaticMethodB extends StaticMethodA{
    /*
    加上@Override报错：Method does not override method from its superclass
    @Override
    */

    //如果父子类中存在了方法签名完全一致的非静态方法，称之为隐藏(hide)
    //如果父子类中存在了方法签名完全一致的方法，要么都是静态的，要么都是非静态的
    public static void m(){
        System.out.println("B running");
    }
}
