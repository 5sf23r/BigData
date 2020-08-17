package cn.commandoptionesc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

//发送端
public class Sender {
    public static void main(String[] args) throws IOException {
       //创建发送端对象
       DatagramSocket ds = new DatagramSocket();
       //对数据进行封包
        //第一个参数表示数据
        //第二个参数表示是数据的大小
        //第三个参数表示的接收的地址和端口号
        byte[] data = "hello receiver".getBytes();
        DatagramPacket dp = new DatagramPacket(
          data,data.length,new InetSocketAddress("localhost",8090)
        );
        //发送数据
        ds.send(dp);
        //关流
        ds.close();
    }
}
