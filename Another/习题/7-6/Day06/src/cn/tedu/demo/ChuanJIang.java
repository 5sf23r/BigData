package cn.tedu.demo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ：cz
 * @date ：Created in 20/7/6 19:38
 * @version: 1.0$
 */
public class ChuanJIang {
    public static void main(String[] args) {
        //--集合在指定泛型的时候，需要传入引用类型
        Collection<String> c= new ArrayList();
        //--集合添加元素
        c.add("abc") ;
        c.add("hehe");
        c.add("nihao");
         //--移除集合中所有的元素
        //c.clear();
//        System.out.println(c.contains("ab"));
//        System.out.println(c.isEmpty());
//        System.out.println(c.remove("abc"));
//        System.out.println(c.size());
        String[] s = c.toArray(new String[0]);
        for (String obj :s){
            System.out.println(obj);
        }
    }
}
