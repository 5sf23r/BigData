package cn.commandoptionesc.stringx;

public class StringDemo2 {
    public static void main(String[] args) {

        String str = "abc";

        //判断字符串是否是指定结尾
        System.out.println(str.endsWith("e"));

        //判断字符串时候是指定开头
        System.out.println(str.startsWith("a"));

        String str2 = new String("abc");
        //System.out.println(str == str2);
        //String的equals做过重写，不在是建单的比较两个字符串的地址是否一样
        //而是比较两个字符串的值是否一样
        System.out.println(str.equals(str2));

        //判断"abc"是否是String对象
        System.out.println("abc" instanceof Object);


        String s1 = "abc";
        String s2 = "ABC";
        System.out.println(s1.equals(s2));
        //忽略大小写比较两个字符串是否一样 --- 用在验证码
        System.out.println(s1.equalsIgnoreCase(s2));

    }
}
