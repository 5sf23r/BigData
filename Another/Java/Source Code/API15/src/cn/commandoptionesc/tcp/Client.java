package cn.commandoptionesc.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        //创建客户端套接子对象
        Socket s = new Socket();
        //发起连接，绑定连接地址和端口号
        s.connect(new InetSocketAddress("localhost",8090));
        //连接之后，获取自带输出流
        OutputStream out = s.getOutputStream();
        //写出数据
        out.write("hello server".getBytes());
        //通知服务器端，数据已经写出完毕
        //输出流一旦关闭不能启动
        s.shutdownOutput();
        //关流
        s.close();
    }
}
