package cn.commandoptionesc.regex;

public class RegexDemo2 {
    public static void main(String[] args) {

        /*
        //判断字符串是否是由一个数字组成
        String str = "1";
        //[xyz] --- 表示x、y、z中的任何一个
        System.out.println(str.matches("[0123456789]"));
        //[]中是一个连写范围的时候，可以使用'-'来表示连续范围
        System.out.println(str.matches("[0-9]"));
        */

        /*
        //匹配：字符串由3个字符组成，第一个字符是小写字母，第二个字符是一个数字，第三个字符是一个大写字母
        String str = "";
        System.out.println(str.matches("[a-z][0-9][A-Z]"));
        */

        /*
        //匹配：字符串由一个字符组成，而这个字符不是a/b/c
        String str = " ";
        System.out.println(str.matches("[^abc]"));
        */


    }
}
