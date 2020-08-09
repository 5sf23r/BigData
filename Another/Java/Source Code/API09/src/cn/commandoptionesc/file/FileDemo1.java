package cn.commandoptionesc.file;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    public static void main(String[] args) throws IOException {

        //表示创建file对象指向Other文件下的ex.txt
        //如果这个文件不存在，那么执行完成之后也不会创建这个文件，但是也不报错
        //在底层只是将传入的字符串标记为一个文件
        //只要不去使用，那么久不会去检查这个文件是否存在

        /*
        //Win系统下 "ex.txt"文件路径写法
        //File file = new File("F:\\ex.txt");
        */

        //Mac系统下 "ex.txt"文件路径写法
        //File file = new File("/Users/admin/Documents/BigData/Another/Java/Other/ex.txt");
        //File file = new File("../Other/ex.txt");

        File file = new File("../Other/ex");

        //创建文件 - 在创建的时候要求制定的路径下没有同名文件
        //返回值表示文件是否创建成功；
        //这个方法只能创建文件不能创建目录
        //boolean b = file.createNewFile();

        //创建目录
        //只能创建目录不能创建文件
        //可以创建多层目录
        //boolean b  = file.mkdirs();

        //删除文件/目录
        //如果利用代码去删除文件，这个文件不是挪到回收站中，而是直接从家计算机删除
        //所以注意，这个操作是不可逆的
        //在删除目录的时候需要目录为空 - 即这个目录中不能有字文件或者字目录
        boolean b = file.delete();
        System.out.println(b);
        System.out.println("运行完成");
    }
}
