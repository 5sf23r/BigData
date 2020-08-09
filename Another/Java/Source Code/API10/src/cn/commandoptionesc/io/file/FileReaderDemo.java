package cn.commandoptionesc.io.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {

        //创建一个输入流，指向要读取的文件
        FileReader reader = new FileReader("../Other/io/ex.txt");
        //读取数据
        //返回值表示的是读取的一个字节
        //int i = reader.read();
        //转化为字符打印出来
        //System.out.println((char)i);

        //需要将文件中所有的数据都读取出来
        //定义一个变量来记录每次读取的数据
        int i;
        //如果读取到了文件的末尾，会返回-1
        while((i = reader.read()) != -1){
            System.out.println((char)i);
        }

        //关流
        reader.close();
    }
}
