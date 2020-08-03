package cn.commandoptionesc.regex;

public class RegexDemo3 {
    public static void main(String[] args) {

        /*
        String str = "abc2def3xyz";
        //将字符串中所有的数字替换为*
        System.out.println(str.replaceAll("[0-9]","*"));

        //将字符串中的所有的数字都去除
        System.out.println(str.replaceAll("[0-9]",""));
        */

        /*
        String str = "我我我我爱爱爱爱学学习";
        //将这个字符串还原为"我爱学习"
        //$n在替换过程中表示引用前边对应编号的捕获组
        System.out.println(str.replaceAll("(.)\\1+","$1"));
        */

        String str = "Amy Sam Tom Bob Lucy";
        System.out.println(str.replaceAll("(.*)(Sam)(.*)(Lucy)","$1$4$3$2"));
    }
}
