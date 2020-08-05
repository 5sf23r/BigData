package cn.tedu.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：cz
 * @date ：Created in 20/7/6 19:51
 * @version: 1.0$
 */
public class ChuanJIang1 {
    public static void main(String[] args) {
        List<String> list1=new ArrayList<>();
        list1.add("a");
        list1.add("c");
        list1.add("h");
        list1.add("k");
        list1.add("h");
        //--可以存储重复元素
//        list.add("h");
//        list.add(3,"f");
//        list.add(-1,"t");
      /*  List<String> list2=new ArrayList<>();
        list2.add("c");
        list2.add("k");
        list2.add("h");
        list2.add("a");
       //--比较是否相等，是通过遍历列表，然后再去逐个进行比较
        System.out.println(list1.equals(list2));*/
//        int a = list1.indexOf("h");
        //System.out.println(list1.remove("h"));
//        list1.set(2,"g");
        //--包头不包尾
        List<String> strings = list1.subList(0, 2);
        System.out.println(strings);

    }
}
