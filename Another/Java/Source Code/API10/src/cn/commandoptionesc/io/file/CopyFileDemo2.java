package cn.commandoptionesc.io.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileDemo2 {
    public static void main(String[] args) throws IOException {

        //创建一个输入流指向要读取的文件
        FileReader reader = new FileReader("../Other/io/ex.txt");
        //创建一个输出流指向要写入的文件
        FileWriter writer = new FileWriter("../Other/io1/ex1.txt");
        //准备一个字符数组作为缓冲区
        char[] cs = new char[10];
        //定义一个变量来记录每次读取到的字符个数
        int len;
        //读取数据
        while((len = reader.read(cs)) != -1){
            //将读取到的数据写出
            writer.write(cs,0,len);
        }
        //关流
        writer.close();
        reader.close();

    }
}
