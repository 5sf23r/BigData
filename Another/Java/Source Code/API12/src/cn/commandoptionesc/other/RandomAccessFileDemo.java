package cn.commandoptionesc.other;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {

        //“r”以只读模式打开文件，对文件进行任何的写操作都是不被允许的
        //"rw"以读写模式打开文件，允许对文件进行读写
        //"rwd"/"rws"以读写模式打开文件，并且要求每次对数据更新都需要同步更新到底层的存储设备上
        //如果数据比较重要不允许丢失，那么可以考虑使用rwd/rws，但是同时意味着这种模式会比较慢
        RandomAccessFile raf = new RandomAccessFile("../Other/io/ex.txt","rw");

        //挪动下标
        raf.seek(10);
        //在读写数据的时候将文件看做是一个大型的字节数组来操作的
        raf.write("abcdef".getBytes());
        System.out.println(raf.read());
        //关流
        raf.close();

    }
}
