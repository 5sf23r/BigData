package cn.commandoptionesc.io.other;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {

        //创建字节流指向要读取的文件
        FileInputStream in1 = new FileInputStream("../Other/io/a.txt");
        FileInputStream in2 = new FileInputStream("../Other/io/b.txt");
        FileInputStream in3 = new FileInputStream("../Other/io/c.txt");
        FileInputStream in4 = new FileInputStream("../Other/io/d.txt");

        //创建一个Vector对象存储FileInputStream
        //Vector是一个集合
        Vector<InputStream> v = new Vector<>();
        v.add(in1);
        v.add(in1);
        v.add(in1);
        //利用合格集合产生一个迭代器
        //Enumeration是最古老的迭代器，出现在Iterator之前
        Enumeration<InputStream> e = v.elements();
        //创建合并流
        SequenceInputStream sis = new SequenceInputStream(e);
        //创建输出流
        FileOutputStream out = new FileOutputStream("../Other/io/union.txt");
        //读取数据
        byte[] data = new byte[10];
        int len;
        while((len = sis.read(data)) != -1){
            //将读取到的数据写出
            out.write(data,0,len);
        }
        //关流
        out.close();
        sis.close();
    }
}
