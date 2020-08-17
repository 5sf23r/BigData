package cn.commandoptionesc.tcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

//文件上传客户端
public class FileUploadClient {
    public static void main(String[] args) throws IOException {

        //创建客户端的套接字对象
        Socket s = new Socket();
        //发起连接
        s.connect(new InetSocketAddress("localhost",8090));
        //获取输入流来读取文件
        FileInputStream in = new FileInputStream("../Other/tcp/b.txt");
        //获取输出流
        OutputStream out = s.getOutputStream();
        //读取文件
        byte[] data = new byte[1024];
        int len;
        while((len = in.read(data)) != -1){
            //将读取到的数据写出
            out.write(data,0,len);
        }
        //通知服务器端数据已经写完
        s.shutdownOutput();
        //关流
        in.close();
        s.close();
    }
}
