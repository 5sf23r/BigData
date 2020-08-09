package cn.commandoptionesc.file;

import java.io.File;

public class FileDemo2 {
    public static void main(String[] args) {

        File file = new File("../Other");

        //获取other文件下所有的子文件和子目录
        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }

        //判断是否是一个文件
        System.out.println(file.isFile());
        //判断是否是一个目录
        System.out.println(file.isDirectory());
    }
}
