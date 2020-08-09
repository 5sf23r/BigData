package cn.commandoptionesc.file;

import java.io.File;
import java.io.FileFilter;

public class FileDemo5 {
    public static void main(String[] args) {
        File file = new File("../Other");

        //获取所有的子文件和子目录
        //File[] files = file.listFiles();
        //for(File f : files){
        //    System.out.println(f);
        //}

        //指向获取子文件
        File[] files = file.listFiles(new FileFilter() {
            @Override
            //在这个方法中指定规则，如果符合规则，那么就会将文件/目录放入数组files中
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });
        for(File f : files){
            System.out.println(f);
        }
    }
}
