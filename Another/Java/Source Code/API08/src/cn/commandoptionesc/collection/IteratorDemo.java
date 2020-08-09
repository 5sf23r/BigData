package cn.commandoptionesc.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorDemo {
    public static void main(String[] args) {


        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("d");
        set.add("e");
        set.add("f");

        //利用迭代器遍历，需要先获取迭代器
        Iterator<String> it = set.iterator();
        //判断是否有下一个
        while(it.hasNext()){
            //挪动指针获取元素
            String s = it.next();
            System.out.println(s);
            //迭代器在迭代过程中不允许直接增删原集合，而是需要通过迭代器提供的remove方法移除
            //set.remove(s);
            it.remove();
        }

        System.out.println(set);
    }
}
