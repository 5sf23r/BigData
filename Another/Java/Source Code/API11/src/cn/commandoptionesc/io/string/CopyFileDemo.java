package cn.commandoptionesc.io.string;

import java.io.IOException;
import java.io.StringReader;

public class CopyFileDemo {
    public static void main(String[] args) throws IOException {

        //这个字符串在运行的时候是存储在内存中
        String str = "hello big data";
        //创建一个流对象指向这个字符串
        StringReader reader = new StringReader(str);
        //定义变量来记录每次读取到的字符
        int i;
        while((i = reader.read()) != -1){
            System.out.println((char) i);
        }
        //关流
        reader.close();

    }
}
