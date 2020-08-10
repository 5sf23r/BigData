package cn.commandoptionesc.io.transform;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {

        //创建一个字节流
        FileInputStream fin = new FileInputStream("../Other/io/ex.txt");
        //创建转化输入流
        //在底层是使用FileenputStream来读取数据
        //读出来的数据是字节形式，但是却以字符形式来提供
        //转换输入流在底层实际上是将字节流转化为字符流
        InputStreamReader in = new InputStreamReader(fin);
        //InputStreamReader in = new InputStreamReader(fin,"gbk");

        //读取数据
        char[] cs = new char[10];
        int len;
        while((len = in.read(cs)) != -1){
            System.out.println(new String(cs,0,len));
        }
        //关流
        in.close();
    }
}
