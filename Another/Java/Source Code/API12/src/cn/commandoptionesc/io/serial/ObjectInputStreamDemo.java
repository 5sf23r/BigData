package cn.commandoptionesc.io.serial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo{
    public static void main(String[] args) throws IOException,ClassNotFoundException {

        //创建反序列化对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("../Other/io/ex.txt"));
        //反序列化对象
        Student s = (Student) in.readObject();
        //关流
        in.close();
        System.out.println(s.getName());
        System.out.println(s.getAge());
    }
}
