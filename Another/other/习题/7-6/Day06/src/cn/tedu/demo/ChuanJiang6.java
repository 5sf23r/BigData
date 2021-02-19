package cn.tedu.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：cz
 * @date ：Created in 20/7/6 21:14
 * @version: 1.0$
 */
public class ChuanJiang6 {
    public static void main(String[] args) {
        //--集合可以存储不同的数据类型的元素
        //--泛型知识发生在编译阶段，运行阶段是没有泛型这个概念的
        List<String> list=new ArrayList();
        List<Integer> list1=new ArrayList<>();
        //--创建泛型类
        Demo1<String,Integer> d=new Demo1();
        d.setT("nihao");
        d.setM(89);
        System.out.println(d.getT());
        System.out.println(d.getM());
    }
}
class Demo1<T,M>{
    private T t;
    private M m;

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
