package cn.commandoptionesc.file;

import java.io.File;

public class FileDemo7 {
    public static void main(String[] args) {

        File file = new File("../Other/ex.txt");

        //将文件设置为只读模式
        //只读的特点：文件可以读取但是不能写入
        //file.setReadOnly();
        //设置不可写
        file.setWritable(false);
        //setReadOnly和setable在windows中的效果是等价的
    }
}
