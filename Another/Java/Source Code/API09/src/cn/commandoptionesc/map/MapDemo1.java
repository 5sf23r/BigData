package cn.commandoptionesc.map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {
    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        //添加元素
        map.put("Bob",15);
        map.put("Alex",17);
        map.put("Helen",14);
        map.put("Peter",16);
        map.put("Mark",15);
        //如果键重复,则对应的f值会被覆盖
        //map.put("Bob",19);

        /*
        Map<String,Integer> map2 = new HashMap<>();
        map2.put("Bob",15);
        map2.put("Alex",17);
        map2.put("Peter",16);
        map2.put("Helen",14);
        map2.put("Mark",15);
        //判断内容是否一样，不是判断顺序
        System.out.println(map.equals(map2));
        */

        //根据指定的键来获取值
        //如果键不存在，则返回一个null
        System.out.println(map.get("Lucy"));

        //判断映射是否为空
        System.out.println(map.isEmpty());

        //移除指定的键对应的键值对
        map.remove("Alex");

        //返回映射中元素个数
        System.out.println(map.size());



        //清空映射
        //map.clear();

        //判断是否包含指定的键
        //System.out.println(map.containsKey("Helen"));

        //判断是否包含指定的值
        System.out.println(map.containsValue(16));

        System.out.println(map);
    }
}
