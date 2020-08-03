package cn.commandoptionesc.stringx;

public class StringDemo4 {
    public static void main(String[] args) {

        /*
        //96345
        String str = "abc";
        //"abc"的哈希吗
        //((31 * h + 'a') * 31 + 'b') * 31 + 'c'
        //"def"的哈希吗
        //((31 * 0 + 'd') * 31 + 'e') * 31 + 'f'
        //同一个字符串的哈希吗一定是相同的
        System.out.println(str.hashCode());
        */

        String str = "big data";
        //获取i出现的下标
        int index = str.indexOf("i");
        System.out.println(index);

        String str1 = "big data";
        //获取指定字符/字符串在字符串中第一次出现的下标
        int index1 = str.indexOf("a");
        System.out.println(index1);

        String str2 = "big data";
        //从指定的下标找指定元素出现的位置
        //如果指定的元素没有找到，则返回 -1
        int index2 = str.indexOf("d",5);
        System.out.println(index2);

        String s1 = "abc";
        String s2 = new String("abc");
        //intern返回这个字符串的常量池地址而不是堆内存的地址
        String s3 = new String("abc").intern();
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        //判断字符串的长度是否为0
        System.out.println(s1.isEmpty());
        String s4 = " ";
        System.out.println(s4.isEmpty());
    }
}
