package cn.commandoptionesc.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {


        Set<String> set = new HashSet<>();
        //不保证元素的存储顺序
        //没有下标
        set.add("big");
        set.add("java");
        set.add("java");
        set.add("commandoptionesc");
        set.add("java");

        for(String str : set){
            System.out.println(str);
        }


        System.out.println(set);
    }
}
