package cn.commandoptionesc.io.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo3 {
    public static void main(String[] args) {

        //正因为传统的流中的异常处理方式比较麻烦，所以在JDK1.7中，提供了一种更简单的处理方法
        //try-with-resources
        //要求放到try()中的数据必须实现closable接口
        try(FileWriter writer = new FileWriter("../Other/io/ex.txt")){
            writer.write("abc");
            //这个close可写可不写，这种方式下，执行完成之后会自动关流
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void m(FileWriter writer){
        //try-with-resources这种方式要求被处理对象的声明过程必须放在try()之中
        try(FileWriter w = writer) {
            writer.write("abc");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
