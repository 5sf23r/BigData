package cn.commandoptionesc.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入一个字符串，然后统计这个字符串哪种每一个字符出现的次数
 */
public class MapExer {
    public static void main(String[] args) {

        //输入一个字符串
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        Map<Character,Integer> map = new HashMap<>();
        //遍历这个字符串中的每一个字符，将每一个字符取出来进行次数计算
        for(int i = 0;i < str.length();i++){
            //获取指定下标位置上的字符
            char c = str.charAt(i);
            //先判断字符之前是否出现过
            if(map.containsKey(c)){
                //如果出现过，那么需要在当前的次数上+1
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }

        //遍历映射，打印次数
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
