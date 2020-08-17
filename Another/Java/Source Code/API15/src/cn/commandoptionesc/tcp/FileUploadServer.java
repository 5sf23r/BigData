package cn.commandoptionesc.tcp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//文件上传服务器
public class FileUploadServer {
    public static void main(String[] args) throws IOException {

        //创建服务器端套接字对象
        ServerSocket ss = new ServerSocket();
        //绑定坚挺的端口号
        ss.bind(new InetSocketAddress(8090));
        //接收连接
        Socket s = ss.accept();
        //创建输出流将数据写出
        FileOutputStream out = new FileOutputStream("../Other/tcp/a.txt");
        //获取输入流
        InputStream in = s.getInputStream();
        //读取数据
        byte[] data = new byte[1024];
        int len;
        while((len = in.read(data)) !=-1){
            //将读取到的数据写到文件中
            out.write(data,0,len);
        }
        //通知客户端数据已经读取完毕
        s.shutdownInput();
        //关流
        out.close();
        ss.close();
    }
}
