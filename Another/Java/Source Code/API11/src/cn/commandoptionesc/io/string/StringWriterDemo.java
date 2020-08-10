package cn.commandoptionesc.io.string;

import java.io.IOException;
import java.io.StringWriter;

public class StringWriterDemo {
    public static void main(String[] args) throws IOException {

        //创建一个流
        //这个流底层实际上是使用了StringBuffer来拼接字符串
        StringWriter writer = new StringWriter();
        //写数据
        //将数据写到内存中
        writer.write("hello");
        writer.write("big data");
        //关流
        writer.close();
    }
}
