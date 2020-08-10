package cn.commandoptionesc.io.filestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileDemo {
    public static void main(String[] args) throws IOException {

        //创建输入流指向要读取的源文件
        FileInputStream in = new FileInputStream("../Other/io/test.png");
        //创建输出流指向要写出的文件
        FileOutputStream out = new FileOutputStream("../Other/test.png");
        //创建一个字节数组作为缓冲区
        byte[] bs = new byte[10];
        //定义一个变量来记录每次读到的字节个数
        int len;
        //读取数据
        while((len = in.read(bs)) != -1){
            //将读取到的数据写出
            out.write(bs,0,len);
        }
        //关流
        in.close();
        out.close();
    }
}
