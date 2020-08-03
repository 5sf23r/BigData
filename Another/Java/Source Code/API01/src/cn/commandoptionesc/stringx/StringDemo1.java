package cn.commandoptionesc.stringx;

public class StringDemo1 {
    public static void main(String[] args) {

        /*
        //字符串是一个常量，定义好之后不能变
        String str = "abc";
        //对字符串改值的时候，实际上是给str赋值了一个新的字符数组的地址
        str = "def";
        System.out.println(str);
         */

        //直接指向运行时常量池的空间地址
        String str1 = "ab";
        //会进入运行时常量池中指向值的地址
        String str2 = new String("ab");
        //"a"和"b"都是字面量，Java在编译的时候会对字面量运算来进行优化
        //所以这句话编译完成之后就是String str3 = "ab";
        //也就意味着str3和str1的地址值是一样的
        String str3 = "a" + "b";

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

        
    }
}
