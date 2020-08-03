package cn.commandoptionesc.regex;

public class RegexDemo1 {
    public static void main(String[] args) {

        /*
        //判断字符串中是否有数字
        String str = "b5a";
        System.out.println(str.matches(".*[0-9].*"));
        */

        /*
        //匹配：由5个小写字符组成的字符串
        String str = "224jhhj";
        //{n}表示恰好出现n次
        System.out.println(str.matches("[a-z]{5}"));
        */

        /*
        //匹配：由至少5个小写字母组成的字符串
        String str = "abcdeg";
        //{n,}表示敲好出现5次
        System.out.println(str.matches("[a-z]{5,}"));
        */

        /*
        //匹配：由6-12个字符组成的字符串
        String str = "";
        //{n,m}表示至少出现n次但是不超过m次
        System.out.println(str.matches(".{6,12}"));
        */
    }
}
