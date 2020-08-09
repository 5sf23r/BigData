package cn.commandoptionesc.collection;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {

        //LinkedList和ArrayList的使用方式一致，但是底层实现是不一样
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("t");

        System.out.println(list);
    }
}
