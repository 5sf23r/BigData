package cn.commandoptionesc.finalx;

public class FinalDemo1 {
    public static void main(String[] args) {

        final int i = 4;
        //Cannot assign a value to final variable 'i'
        //i = 5;

        //此时arr在栈内存存储的地址，所以final限制的是arr的地址不能变
        final int[] arr = {3,4,6,8};

        //做地址改变，不可行，报错
        //arr = new int[3];

        //没有改变地址，只是改变了元素值
        arr[0] = 10;
        System.out.println(arr[0]);
    }
}

class A {

    //final也可以修饰成员属性，称之为成员常量
    //final int id = 5;

    /*
    final int id;

    {
        id = 5;
    }*/

    /*
    //对于非静态成员常量而言，只需要在构造方法执行完成之前给值即可
    //final常量的值只能给一次
    final int id;
    public A(int id){
        this.id = id;
    }
     */

    //静态常量
    //final static int id = 6;

    final static int id;
    static{
        id = 6;
    }
}
