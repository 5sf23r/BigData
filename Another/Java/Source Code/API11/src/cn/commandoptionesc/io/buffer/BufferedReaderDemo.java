package cn.commandoptionesc.io.buffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {

        //实际上是利用这个流去读取数据
        FileReader fr = new FileReader("../Other/io/ex.txt");
        //创建一个缓冲流 - 在构建缓冲流的时候需要传入一个其他的字符输入流
        //这个流失提供缓冲区的FileReader读取出数据之后，会利用这个BufferedReader
        BufferedReader reader = new BufferedReader(fr);
        //按行读取
        //String line = reader.readLine();
        //System.out.println(line);
        //定义变量来记录每一行数据
        String line;
        //如果读取到文件末尾，返回一个null
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        //关流
        //可以只关外层流 - 会顺带着将里层的流关掉
        reader.close();
    }
}
