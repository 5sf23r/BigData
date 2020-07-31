package cn.commandoptionesc.innerclass;

public class InnerClassDemo3 {
    public static void main(String[] args) {

        Outer3.Inner3 oi3 = new Outer3.Inner3();
        oi3.m();
    }
}

class Outer3{

    int i = 5;
    static int j = 8;

    //静态内部类可以使用权限修饰符final/abstract修饰
    static final class Inner9{}
    static public class Inner8{}
    static abstract class Inner7{}

    //静态内部类可以继承别的类，也可以实现接口
    static class Inner6 extends Exception{}
    static class Inner5 implements Cloneable{}

    //用static修饰的内部类称之为静态内部类
    static class Inner3{


        //静态内部类中可以定义非静态方法和非静态属性，也可以静态方法和静态属性
        int x = 4;
        static int y = 6;

        public void m(){

            /*
            //静态内部类不能使用外部类中的非静态属性和非静态方法
            System.out.println(i);
            */

            //静态内部类中可以使用外部类中的静态属性和静态方法
            System.out.println(j);



        }
    }
}
