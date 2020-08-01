//定义包的语句必须放在整个Java的第一行
package cn.commandoptionesc.packagex;

//如果需要使用不同包的类，需要用import来导包
//可以使用*导入指定包下的所有的类
//表示导入java.util包下的所有的类但是不包括util子包的类
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
//import java.util.Arrays;
//import java.util.Scanner;


public class PackageDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(Arrays.toString(new int[]{2,4,5,6}));
        //ConcurrentHashMap
    }
}
