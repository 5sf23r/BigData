package cn.commandoptionesc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//接收端
public class Receiver {
    public static void main(String[] args) throws IOException {

        //创建接收端对象，绑定监听的端口
        DatagramSocket ds = new DatagramSocket(8090);
        //准备数据包接收数据
        DatagramPacket dp = new DatagramPacket(new byte[1024],1024);
        //接收数据
        ds.receive(dp);
        //关流
        ds.close();
        //解析数据
        byte[] data = dp.getData();
        //获取数据的实际长度
        int len = dp.getLength();
        System.out.println(new String(data,0,len));
    }
}
