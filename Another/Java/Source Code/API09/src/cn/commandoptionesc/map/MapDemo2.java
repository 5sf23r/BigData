package cn.commandoptionesc.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {
    public static void main(String[] args) {


        Map<String,Integer> map = new HashMap<>();
        map.put("Bob",15);
        map.put("Alex",17);
        map.put("Helen",14);
        map.put("Peter",16);
        map.put("Mark",15);

        /*
        //方式一：
        //先获取所有的键 - 将所有的键放入一个Set集合中
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key + "=" + map.get(key));
        }
        */

        //方式二：
        //可以考虑直接获取所有的键值对 - 将所有的键值对放入一个Set集合中
        //此时Set中存放的是键值对，所以泛型应该表示键值对，即泛型应该是Entry类型
        Set<Map.Entry<String,Integer>> entrys = map.entrySet();
        for(Map.Entry<String,Integer> entry : entrys){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }






    }
}
