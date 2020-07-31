package cn.commandoptionesc.innerclass;

public class InnerClassDemo2 {
    public static void main(String[] args) {

        /*
        //创建外部类对象
        Outer2 o2 = new Outer2();
        */

        //表示创建了一个内部类对象
        Outer2.Inner2 oi2 = new Outer2().new Inner2();
        oi2.m();
    }
}

class Outer2{

    int i = 3;
    //在类中定义了一个内部类，这个内部类称之为成员内部类
    //成员内部类可以继承别的类或者实现接口
    //成员内部类可以使用权限修饰符final/abstract修饰
    class Inner2{

        int j = 3;

        int i = 7;

        /*
        //成员内部类中可以定义非静态属性和非静态方法，但是不能定义静态变量和静态方法
        static int m = 8;
        */

        //成员内部类可以定义静态常量
        static final int n = 8;


        public void m(){

            //当内部类和外部类存在同名属性的时候,通过外部类.this.属性来调用
            System.out.println(Outer2.this.i);

            //成员内部类使用外部类中的一切属性和方法
            System.out.println(i);
        }
    }
}
