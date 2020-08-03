package cn.commandoptionesc.stringx;

public class StringDemo5 {
    public static void main(String[] args) {

        /*
        String str = "data";
        //lastIndexof表示找指定的字符串最后一次出现的下标
        int index = str.lastIndexOf("a");
        System.out.println(index);

        //获取指定字符串的长度
        System.out.println(str.length());

        //用指定字符进行替换
        //将这个字符串中的'a'替换为'+'
        System.out.println(str.replace('a','+'));
        */

        String str1 = "big data";
        //从指定下标开始，截取到末尾来截取一个子字符串
        String sub = str1.substring(4);
        System.out.println(sub);

        //在Java中，一般表示范围的时候，包括头部但是不包括尾部
        String sub1 = str1.substring(4,7);
        System.out.println(sub1);

        //将字符串中的所有的字符转化为大写
        System.out.println(str1.toUpperCase());

        //这个方法对汉字没有影响
        String str2 = "大数据";
        System.out.println(str2.toUpperCase());

        String str3 = "COMMAND OPTION";
        //将字符串中的所有的字符转化为小写
        System.out.println(str3.toLowerCase());

        //去掉字符串头部和尾部的空白字符
        String str = "    \t abc      ";
        System.out.println(str);
        System.out.println(str.trim());
    }
}
