package cn.commandoptionesc.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {

        //创建一个集合对象
        //表示创建了一个集合，集合中存储的元素类型是String
        //集合在创建的时候，后边类型的泛型可以不写，会根据前边的类型进行自动推到
        Collection<String> c = new ArrayList<>();

        //添加元素
        c.add("a");
        c.add("b");
        c.add("f");

        String[] arr = c.toArray(new String[0]);
        for(String s : arr){
            System.out.println(s);
        }

        Object[] os = c.toArray();
        for(Object o : os){
            System.out.println(o);
        }

        //获取元素个数
        System.out.println(c.size());

        //判断元素是否存在
        boolean r = c.contains("o");
        System.out.println(r);

        //清空集合
        c.clear();

        //判断集合是否为空
        System.out.println(c.isEmpty());


        //删除指定的元素
        c.remove("b");
        //如果移除的元素不存在，则不会出现任何问题
        //底层会首先判断这个元素是否存在
        c.remove("e");

        System.out.println(c);
    }
}
