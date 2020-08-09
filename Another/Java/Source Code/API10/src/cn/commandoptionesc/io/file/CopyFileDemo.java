package cn.commandoptionesc.io.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//将ex.txt文件赋值一份方法哦另外一个文件夹
public class CopyFileDemo {
    public static void main(String[] args) throws IOException {

        //创建输入流指向要读取的文件
        FileReader reader = new FileReader("../Other/io/ex.txt");
        //创建输出流指向要写出的文件
        FileWriter writer = new FileWriter("../Other/io1/ex.txt");
        //读取数据
        //定义变量用于记录每次读取的数据
        int i;
        //定义循环来读取数据
        while((i = reader.read()) != -1){
            //需要将读取到的数据来写出
            writer.write(i);
        }
        //关流
        reader.close();
        writer.close();
    }
}
