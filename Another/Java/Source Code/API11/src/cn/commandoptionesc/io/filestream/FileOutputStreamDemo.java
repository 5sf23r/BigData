package cn.commandoptionesc.io.filestream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {

        //创建一个文件字节输出流
        FileOutputStream out = new FileOutputStream("../Other");
        //写出数据
        //字节流没有缓冲区，会将数据直接写到文件中
        out.write("hello".getBytes());
        //关流
        out.close();
    }
}
