package cn.commandoptionesc.regex;

public class RegexDemo2 {
    public static void main(String[] args) {

        /*
        //匹配：字符串中出现2次 "ab" 的字符串
        String str = "sfsfsf";
        //当()将一些字符放在一组的时候，构成了正则表达式中的捕获组
        System.out.println(str.matches(".*(ab).*(ab).*"));

        //捕获组的编号是从1开始依次向上递增
        // \\n表示引用前边对应编号的捕获组
        System.out.println(str.matches(".*(ab).*\\1.*"));
        */

        /*
        //匹配：叠字
        String str = "哈哈哈";
        System.out.println(str.matches("(.)\\1+"));
        */

        /*
        //匹配：AABB形式的词语
        String str = "高高兴兴";
        System.out.println(str.matches("(.)\\1(.)\\2"));
        */

        /*
        //匹配：ABAB形式的词语
        String str = "溜达溜达";
        System.out.println(str.matches("(..)=\\1"));
        */

        //捕获组的编号是从(出现的顺序开始依次编号)
        // (A(BC)D)E)(F)
        // \\1 A((BC)D)E
        // \\2 (BC)D
        // \\3 BC
        // \\4 F
    }
}
