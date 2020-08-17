package cn.commandoptionesc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class ChatDemo {
    public static void main(String[] args) {
        new Thread(new MessageSender()).start();
        new Thread(new MessageReceiver()).start();
    }
}

//消息发送端
class MessageSender implements Runnable{
    @Override
    public void run() {

        try {
            //创建发送端对象
            DatagramSocket ds = new DatagramSocket();
            //创建Scanner对象
            Scanner s = new Scanner(System.in);
            while(true){
                //从控制台来接收数据
                String message = s.nextLine();
                //就需要将接收到的数据进行封包
                DatagramPacket dp = new DatagramPacket(
                        message.getBytes(),message.getBytes().length,
                        new InetSocketAddress("localhost",8070)
                );
                //发送数据
                ds.send(dp);
                //如果输入的数据是over~，表示结束聊天
                if(message.equals("over~"))
                    break;
            }
            //关流
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//消息接收端
class MessageReceiver implements Runnable {
    @Override
    public void run() {
        try {
            //创建接收端对象，绑定监听的端口号
            DatagramSocket ds = new DatagramSocket(8070);
            //准备数据包
            DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
            while (true) {
                //接收数据
                ds.receive(dp);
                //解析数据
                //获取底层的字节数组
                byte[] data = dp.getData();
                //获取数据长度
                int length = dp.getLength();
                String message = new String(data, 0, length);
                //如果收到对方的over~表示对方结束了聊天
                if(message.equals("over~")){
                    System.out.println("对方结束了聊天");
                    break;
                }
                System.out.println(message);
            }
            //关流
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}