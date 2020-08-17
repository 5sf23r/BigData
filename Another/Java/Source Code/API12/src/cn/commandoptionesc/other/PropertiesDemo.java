package cn.commandoptionesc.other;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        //添加元素
        prop.setProperty("name","Helen");
        prop.setProperty("gender","female");
        //序列化
        //Properties提供了store方法来直接序列号华
        FileOutputStream out = new FileOutputStream("../Other/io/ex.txt");
        //第二个参数实际上是在文件中添加注释
        prop.store(out,null);
    }
}
