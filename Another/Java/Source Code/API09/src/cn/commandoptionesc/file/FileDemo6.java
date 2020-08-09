package cn.commandoptionesc.file;

import java.io.File;

public class FileDemo6 {
    public static void main(String[] args) {

        File file = new File(".//Other/ex.txt");

        //如果路径没有发生变化只是文件名改变，那么久执行重命名操作
        //如果文件名没有发生变化但是路径改变，那么久执行剪切操作
        //也可以路径和文件名同时变化
        file.renameTo(new File("../Other/ex1.txt"));
    }
}
