package cn.tedu.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.net.URI;

public class HDFSDemo {

    // 下载文件
    @Test
    public void get() throws IOException {

        // 创建一个URI对象来指向连接地址
        // 50070 这个HDFS提供的HTTP访问端口
        // 9000 配置的HDFS的RPC访问端口
        URI uri = URI.create("hdfs://192.168.23.130:9000");
        Configuration conf = new Configuration();
        // 连接HDFS
        FileSystem fs = FileSystem.get(uri, conf);
        // 打开文件
        // 返回一个输入流
        InputStream in = fs.open(new Path("/a.txt"));
        // 创建一个输出流
        FileOutputStream out = new FileOutputStream("D:\\a.txt");
        // 利用输入流来读取数据，然后将读取的数据利用输出流写出
        IOUtils.copyBytes(in, out, conf);
        // 关流
        in.close();
        out.close();

    }

    // 上传文件
    @Test
    public void put() throws IOException, InterruptedException {

        // 连接HDFS
        URI uri = URI.create("hdfs://192.168.23.130:9000");
        // 放到配置文件中的内容，都可以通过这个参数配置
        Configuration conf = new Configuration();
        conf.set("dfs.replication", "1");
        // conf.set("dfs.blocksize", "");
        // 权限验证：所知即所得
        FileSystem fs = FileSystem.get(uri, conf, "root");
        // 创建文件
        OutputStream out = fs.create(new Path("/log/b.log"));
        // 创建一个输入流指向要上传的文件
        FileInputStream in = new FileInputStream("D:\\a.txt");
        // 数据传输
        IOUtils.copyBytes(in, out, conf);
        // 关流
        in.close();
        out.close();

    }

    // 删除文件
    @Test
    public void delete() throws IOException, InterruptedException {

        // 连接HDFS
        URI uri = URI.create("hdfs://192.168.23.130:9000");
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(uri, conf, "root");
        // 删除文件
        fs.delete(new Path("/log"), true);
    }

}
