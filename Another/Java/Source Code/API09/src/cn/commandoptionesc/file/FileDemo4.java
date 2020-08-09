package cn.commandoptionesc.file;

import java.io.File;

public class FileDemo4 {
    public static void main(String[] args) {

        File file = new File("../Other/ex.txt");

        /*
        //这三个方法的特点，都不会去判断这个文件是否存在
        //separatorChar - 路径分隔符，实际上就是 '/'
        //获取文件名
        System.out.println(file.getName());
        //获取父目录
        System.out.println(file.getParent());
        //获取路径 - 在创建file的时候，传入什么路径，这儿获取的就是什么路径
        System.out.println(file.getPath());
        */

        //判断是否是一个隐藏文件
        //System.out.println(file.isHidden());

        //获取文件的大小
        //System.out.println(file.length());
    }
}
