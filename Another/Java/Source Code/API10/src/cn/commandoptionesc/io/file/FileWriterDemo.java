package cn.commandoptionesc.io.file;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {

        //指定写入的文件
        //如果文件不存在，会创建一个新文件
        //如果文件存在，也会创建一个新文件将原来的文件覆盖掉
        //FileWriter writer = new FileWriter("../Other/io/ex.txt");

        //如果不想产生新文件将原来的文件覆盖，就需要在创建流对象的时候添加布尔值
        FileWriter writer = new FileWriter("../Other/io/ex.txt",true);

        //写数据
        //数据并不是直接写到文件中，而是先写到缓冲区中
        //等缓冲区满了，然后在将缓冲区中的数据放到文件中
        //现在缓冲区没有塞满，程序结束了，数据没有写到文件中，而是死在了缓冲区中
        writer.write("hello big data");

        //冲刷缓冲区
        writer.flush();

        //需要关流，释放文件
        //close之前，在底层会自动进行一次冲刷操作
        writer.close();

        System.out.println("运行完成");

    }
}
