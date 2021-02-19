package cn.tedu.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：cz
 * @date ：Created in 20/7/6 21:29
 * @version: 1.0$
 */
public class ChuanJiang8 {
    public static void main(String[] args) {
        List<B> b=new ArrayList<>();
        List<C> c=new ArrayList<>();
        List<D> d=new ArrayList<>();
        List<? extends A> l=new ArrayList<>();
        //--如果理解为它是所有继承了A类的一个子类的集合，这种理解是错误的。是A的一个子类
        //--1.l对象去调用add方法。不管是添加什么对象都会报错；--》? extends A
        //--l对象调用add方法只能添加B或者B的子类--》? super B



    }
    //--遍历打印A以及A的子类对象
    public static void foreachA(List<? super B> aL){

    }
}
class A{

}
class B extends A{

}
class C extends A{

}
class D extends B{

}
