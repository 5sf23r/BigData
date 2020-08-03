package cn.commandoptionesc.regex;

public class RegexDemo4 {
    public static void main(String[] args) {

        /*
        //匹配：由小写字母组成的字符串
        String str = "ace";
        //可以理解为这个字符串中至少由一个小写字母组成
        // + 表示至少一次
        System.out.println(str.matches("[a-z] + "));
        */

        /*
        //匹配：由数字开头的最多2个字符组成的字符串
        String str = "32";
        // ? 表示之多一次
        System.out.println(str.matches("[0-9].?"));
        */

        //匹配：由数字开头的字符串
        String str = "2a3";
        // * 表示零次或者多次
        System.out.println(str.matches("[0-9].*"));
    }
}
