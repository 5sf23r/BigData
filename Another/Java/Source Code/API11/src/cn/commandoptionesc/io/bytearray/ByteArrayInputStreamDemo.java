package cn.commandoptionesc.io.bytearray;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamDemo {
    public static void main(String[] args) throws IOException {

        //准备字节数组
        byte[] data = "hello big data".getBytes();
        //创建一个字节数组输入流
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        //读取数据
        byte[] bs = new byte[5];
        int len;
        while((len = in.read(bs)) != -1){
            System.out.println(new String(bs,0,len));
        }
        //关流
        in.close();
    }
}
