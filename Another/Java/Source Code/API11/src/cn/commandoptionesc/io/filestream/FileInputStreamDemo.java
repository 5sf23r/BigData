package cn.commandoptionesc.io.filestream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {

        //穿件文件字节输出流
        FileInputStream in = new FileInputStream("../Other/io/ex.txt");
        //创建一个字节数组作为缓冲区
        byte[] bs = new byte[10];
        //定义一个变量记录每次读取到的字节个数
        int len;
        //读取数据
        while((len = in.read(bs)) != -1){
            System.out.println(new String(bs,0,len));
        }
        //关流
        in.close();
    }
}
