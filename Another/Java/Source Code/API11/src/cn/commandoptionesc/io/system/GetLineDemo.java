package cn.commandoptionesc.io.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetLineDemo {
    public static void main(String[] args) throws IOException {

        //从控制台来获取一行数据
        //从控制台读取数据 --- System.in
        //读取一行数据 --- BufferedReader
        //BufferedReader在构建的时候需要传入一个字符流，但是System.in是字节流
        //将字节流转化为字符流 - InputStreamReader
        InputStreamReader in = new InputStreamReader((System.in));
        BufferedReader reader = new BufferedReader(in);
        //读取一行数据
        String line = reader.readLine();
        System.out.println(line);
        //系统流用完之后不需要关闭
    }
}
