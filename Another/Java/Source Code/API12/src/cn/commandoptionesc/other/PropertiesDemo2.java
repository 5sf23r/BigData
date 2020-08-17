package cn.commandoptionesc.other;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo2 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        //反序列化
        FileInputStream in = new FileInputStream("../Other/io/ex.txt");
        prop.load(in);
        in.close();

        //System.out.println(prop.getProperty("name"));
        //遍历Properties
        prop.list(System.out);
    }
}
