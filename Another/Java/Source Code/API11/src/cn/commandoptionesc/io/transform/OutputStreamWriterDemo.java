package cn.commandoptionesc.io.transform;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {

        //创建字节流
        FileOutputStream fout = new FileOutputStream("../Other/io/ex.txt");
        //创建转换输出流
        //实际底层依然是利用FileOutputStream来写出，但是对外提供确实以字符流形式来提供
        //在底层将字符转化为字节，然后以字节形式来写出
        //如果没有指定编码，那么数据和当前工程的编码一致
        OutputStreamWriter out = new OutputStreamWriter(fout);
        //OutputStreamWriter out = new OutputStreamWriter(fout,"gbk");
        //写出数据
        out.write("什么东西");
        //关流
        out.close();
    }
}
