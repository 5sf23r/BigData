package cn.commandoptionesc.regex;

import java.util.Arrays;

public class RegexDemo4 {
    public static void main(String[] args) {

        String str = "abc2def3xyz";
        //以数字为符号将字符串切分
        //作为切分符号的数字在切分过程中会被切掉
        String[] arr = str.split("[0-9]");
        System.out.println(Arrays.toString(arr));
    }
}
