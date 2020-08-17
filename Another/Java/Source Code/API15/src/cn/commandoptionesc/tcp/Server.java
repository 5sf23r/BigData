package cn.commandoptionesc.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        //创建服务器端套接字对象
        ServerSocket ss = new ServerSocket();
        //绑定监听的端口号
        ss.bind(new InetSocketAddress(8090));
        //接收连接
        Socket s = ss.accept();
        //获取输入流
        InputStream in = s.getInputStream();
        //读取数据
        byte[] data = new byte[1024];
        int len;
        while((len = in.read(data)) != -1){
            System.out.println(new String(data,0,len));
        }
        //读取完成之后，需要通知客户端数据一定读完
        //输入流一旦关闭不能开启
        s.shutdownInput();
        //关流
        ss.close();
    }
}
