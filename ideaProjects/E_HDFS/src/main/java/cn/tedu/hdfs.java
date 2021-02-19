package cn.tedu;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.net.URI;

public class hdfs {
    // 下载文件
    @Test
    public void get() throws IOException {
        // 创建一个URI对象来指向连接地址
        // 50070 这个HDFS提供的HTTP访问端口
        // 9000 配置的HDFS的RPC访问端口
        URI uri = URI.create("hdfs://192.168.50.155:9000");
        Configuration conf = new Configuration();
        // 连接HDFS
        FileSystem fs = FileSystem.get(uri,conf);
        // 打开文件
        // 返回一个输入流
        InputStream in = fs.open(new Path("/one"));
        // 创建一个输出流
        FileOutputStream out = new FileOutputStream("/Users/coe/commandoptionesc/other/one");
        //利用出入流来读取数据，然后将读取的数据利用输出流写出
        IOUtils.copyBytes(in,out,conf);
        //关流
        in.close();
        out.close();
    }
    // 上传文件
    @Test
    public void put() throws IOException, InterruptedException {
        // 连接HDFS
        URI uri = URI.create("hdfs://192.168.50.155:9000");
        Configuration conf = new Configuration();
        // 放到配置文件的内容，都可以通过这个参数配置
        conf.set("dfs.replication","1");
        // conf.set("dfs.blocksize","");
        // 权限验证：所之既所得
        FileSystem fs = FileSystem.get(uri,conf,"root");
        // 创建文件
        OutputStream out = fs.create(new Path("/one1.txt"));
        // 创建一个输入流指向要上传的文件
        FileInputStream in = new FileInputStream("/Users/coe/commandoptionesc/other/one1");
        // 数据传输
        IOUtils.copyBytes(in,out,conf);
        // 关流
        in.close();
        out.close();
    }
    // 删除文件
    @Test
    public void delete() throws IOException, InterruptedException {
        // 连接HDFS
        URI uri = URI.create("hdfs://192.168.50.155:9000");
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(uri,conf,"root");
        //删除文件
        fs.delete(new Path("/one1.txt"),true);
    }

}
