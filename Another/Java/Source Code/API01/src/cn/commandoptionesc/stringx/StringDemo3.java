package cn.commandoptionesc.stringx;

public class StringDemo3 {
    public static void main(String[] args) {

        /*
        String str = "big data";
        //获取字符串指定下标位置上的字符
        char c = str.charAt(2);
        System.out.println(c);

        //将字符串转化为字符数组
        char[] cs = str.toCharArray();
        for(char c1 : cs){
            System.out.println(c1);
        }
        */

        //将字符数组转化为字符串
        char[] cs = {'b','i','g',' ','d','a','t','a'};
        String str = new String(cs);
        System.out.println(str);
    }
}
