package cn.commandoptionesc.innerclass;

public class InnerClassDemo1 {
    public static void main(String[] args) {

    }
}

class Outer1{

    int x = 4;
    static int y = 5;
    public void m(){
        int i = 3;
        System.out.println("m running");

        //在方法中定义的类，称之为方法内部类/局部内部类
        //可以使用外部类的成员属性和方法
        //方法内部类可以继承类，也可以实现接口
        //方法内部类可以使用final或者是abstract修饰
        class Inner1 {

            int a = 3;

            /*
            //方法内部类中可以声明非静态属性和方法，可以声明静态常量，但是不能声明静态变量和静态方法
            //static int b = 4;
            static final int b = 5;
            */

            public void m(){
                x = 5;

                /*
                //方法内部类使用当前方法中的数据的时候，要求这个数据要是一个常量
                //Variable 'i' is accessed from within inner class, needs to be final or effectively final
                i = 6;
                */

                System.out.println(x);
                System.out.println(y);
                System.out.println(i);
                System.out.println("inner m running");
            }
        }

        Inner1 i1 = new Inner1();
        i1.m();

    }
}
