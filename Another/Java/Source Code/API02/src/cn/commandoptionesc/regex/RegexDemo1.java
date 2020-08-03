package cn.commandoptionesc.regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo1 {
    public static void main(String[] args) {

        //判断一个字符串是否是"abc"

        // 第一种
        String str = "demo1";
        System.out.println(str.equals("abc"));

        //第二种
        String str1 = "demo3";
        //利用正则表达式完成判断
        //利用这个对象来指定规则
        Pattern p = Pattern.compile("abc");
        //需要获取一个匹配器
        Matcher m = p.matcher(str1);
        //获取一个匹配结果
        boolean b = m.matches();
        System.out.println(b);

        //第三种
        //第三种等价于第二种
        boolean b2 = str.matches("abc");
        System.out.println(b2);
    }
}
