package cn.commandoptionesc.net;

import java.net.InetSocketAddress;

public class InetSocketAffressDemo {
    public static void main(String[] args) {

        //表示创建了InetSocketAddress，指向了www.baidu.com这个地址
        InetSocketAddress isa = new InetSocketAddress("www.baidu.com",8090);
        //获取端口号
        System.out.println(isa.getPort());
        //获取主机名 - 在网络中，主机名往往是域名；如果是单台主机名，主机名指的就是计算机名
        System.out.println(isa.getHostName());
    }
}
