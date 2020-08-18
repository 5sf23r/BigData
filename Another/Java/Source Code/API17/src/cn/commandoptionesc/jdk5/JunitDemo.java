package cn.commandoptionesc.jdk5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class JunitDemo {

    FileWriter writer;
    @Before
    public void init() throws IOException {
        writer = new FileWriter("../Other/d.txt",true);
    }

    @Test
    public void write1() throws IOException{
        System.out.println("测试方法1");
        writer.write("abc");

    }

    @Test
    public void write2() throws IOException{
        System.out.println("测试方法2");
        writer.write("def");
    }

    @After
    public void close() throws IOException{
        System.out.println("关流");
        writer.close();
    }
}
