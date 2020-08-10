package cn.commandoptionesc.io.bytearray;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

class ByteArrayOutputStreamDemo {
    public static void main(String[] args) throws IOException {

        //创建一个字节数组输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //写出数据
        //产生一个字节数组放到内存中
        out.write("hello".getBytes());
        //关流
        out.close();
        byte[] data = out.toByteArray();
        System.out.println(new String(data));
    }
}
