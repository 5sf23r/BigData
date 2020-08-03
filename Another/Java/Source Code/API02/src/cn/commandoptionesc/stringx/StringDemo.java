package cn.commandoptionesc.stringx;

public class StringDemo {
    public static void main(String[] args) {

        /*
        //7
        String s1 = "hijklmn";
        String s2 = "abcdefg";
        System.out.println(s1.compareTo(s2));
        */

        //-10
        String s1 = "hijklmn";
        String s2 = "hsafsaf";
        /*
            1. 当比较两个字符串的时候，实际上底层会将这两个字符串转化为字符串
                s1 --- arr1,s2 --- arr2
            2. 拿两个字符组对应位置上的字符进行比较
            3. 如果对应位置上的字符一样，则比较下一位
            4. 如果对应位置上的字符不一样，则返回对应位置上的字符之差
            5. 如果每一位都一样，但是一个字符数组首先遍历完，那么返回两个字符数组的长度之差
         */
        //如果返回值是正数，则说明s1 > s2
        //如果返回值是负数，则说明s1 < s2
        System.out.println(s1.compareTo(s2));

        //a - 97
        //A - 65
        String s3 = "abcdef";
        String s4 = "ABCDEF";
        System.out.println(s3.compareTo(s4));
        //忽略大小写进行比较
        System.out.println(s3.compareToIgnoreCase(s4));

        //concat()方法用于将指定的字符串参数连接到字符串上
        String s5 = "asdfgh";
        String s6 = "zxcvbn";
        System.out.println(s5.concat(s6));
        System.out.println(s5);

        //判断字符串中是否包含指定子串，包含返回true否则false
        System.out.println(s5.contains("a"));
    }
}
