package cn.commandoptionesc.stringx;

public class StringDemo3{
    public static void main(String[] args) throws Exception{

        /*
        String str = "大数据";

        //将字符串按照当前项目的默认编码转化为字节数组
        //idea中默认编码是UTF-8
        //将字符转化为字节考虑编码，按照不同的编码转化出来的字节个数也是不一样的
        //byte[] bs = str.getBytes();
        //将字符串按照指定编码转化为字节数组
        byte[] bs = str.getBytes("gbk");
        System.out.println(bs.length);
        */

        /*
        //将字节数组转化为字符串
        //如果不指定编码，则是使用当前项目的编码
        byte[] bs = {97,98,99,100,101,102,103};
        //String str = new String(bs);

        //指定编码
        //String str = new String(bs,"gbk");

        System.out.println(str);
        */

        //将字节数组指定部分的元素转化为字符串
        //第二个参数表示从字节数组的哪一个位置开始转换
        //第三个参数表示要转化的字节个数
        byte[] bs2 = {97,98,99,100,101,102,103};
        String str = new String(bs2,2,4);

        System.out.println(str);

    }
}
