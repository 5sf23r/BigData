package cn.commandoptionesc.io.other;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UnionFileDemo {
    public static void main(String[] args) throws IOException {

        copy("../Other/io/a.txt","../Other/io/union.txt");
        copy("../Other/io/b.txt","../Other/io/union.txt");
        copy("../Other/io/c.txt","../Other/io/union.txt");
        copy("../Other/io/d.txt","../Other/io/union.txt");


    }

    public static void copy(String inpath,String outpath) throws IOException{

        //创建一个输入流来指向输入路径
        FileInputStream in = new FileInputStream(inpath);
        //创建一个输出流来指向输出路径
        FileOutputStream out = new FileOutputStream(inpath);

    }
}
