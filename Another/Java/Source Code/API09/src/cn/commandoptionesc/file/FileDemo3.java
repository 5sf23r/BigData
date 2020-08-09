package cn.commandoptionesc.file;

import java.io.File;

public class FileDemo3 {
    public static void main(String[] args) {

        File file = new File("../Other/ex.txt");

        //判断这个文件/目录是否是一个可执行文件/目录
        //但是这个方法在windows中没有办法测试
        //可执行：打开、读取、写入、删除
        //boolean b = new file.canExecute();
        //System.out.println(b);

        //判断文件是否可写
        //boolean b = file.canWrite();
        //System.out.println(b);

        //判断文件或者目录是否存在

        //System.out.println(file.exists());

        /*
        //获取指定目录的可用空间，返回值是以字节来计数的，所以返回值类型是long
        File file1 = new File("../Other");
        System.out.println(file.getFreeSpace());
        */
    }
}
