package cn.tedu.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ：cz
 * @date ：Created in 20/7/6 21:03
 * @version: 1.0$
 */
public class ChuanJiang5 {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("xiaoming");
        set.add("xiaomei");
        set.add("xiaowang");
        set.add("xiaozhang");
        //--获取迭代器
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }

    }
}
