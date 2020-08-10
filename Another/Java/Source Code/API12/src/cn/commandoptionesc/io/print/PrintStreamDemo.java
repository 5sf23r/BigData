package cn.commandoptionesc.io.print;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {

        //创建打印流
        PrintStream ps = new PrintStream("../Other/io/ex.txt");
        //写出数据
        //写出一行数据并且换行
        ps.print("hello");
        ps.print("big data");
        //关流
        ps.close();
    }
}
