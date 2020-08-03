package cn.commandoptionesc.stringx;

public class StringDemo6 {
    public static void main(String[] args) {

        /*
        Object o = new Object();
        String s1 = o.toString();
        //对于对象而言，对象的toString和String.valueOf的效果是一样的
        String s2 = String.valueOf(o);
        System.out.println(s1);
        System.out.println(s2);
        */

        int[] arr = {2,3,7};
        String s1 = arr.toString();
        String s2 = String.valueOf(arr);
        System.out.println(s1);
        System.out.println(s2);

        char[] cs = {'a','b','c'};
        //对于字符数组而言，String.valueOf和toString方法的效果是不一样的
        //toString是获取字符数组的地址
        String s3 = cs.toString();
        //将字符数组中的每一个元素拿出来拼接成了一个字符串，而不是打印这个字符数组的地址
        String s4 = String.valueOf(cs);
        System.out.println(s3);
        System.out.println(s4);
    }
}
