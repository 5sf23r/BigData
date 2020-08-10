package cn.commandoptionesc.io.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {

        //准备一个Student对象
        Student s = new Student();
        s.setName("Alex");
        s.setAge(15);
        //s.classroom = "302";
        s.setHeight(144.8);

        //创建一个序列化流
        //表示序列化产生的数据写到"../Other/io/ex.txt中
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("../Other/io/ex.txt"));
        //序列化对象
        out.writeObject(s);
        //关流
        out.close();
    }
}
