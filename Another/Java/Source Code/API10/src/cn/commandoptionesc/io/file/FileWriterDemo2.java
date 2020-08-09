package cn.commandoptionesc.io.file;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo2 {
    public static void main(String[] args) {

        //需要将writer进行外置声明,并且赋予null值进行初始化
        FileWriter writer = null;
        try {
            //放到try之内进行初始化去创建这个流对象
            writer = new FileWriter("../Other/io/ex.txt");
            writer.write("hello");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //在关流之前需要判断流是否初始化成功，实际上就是判断流是否为空
            if(writer != null){

                try {
                    //无论前面执行成功与否，这个流都需要进行关闭
                    //如果close失败，那么这个流会依然占用文件，其他流就无法使用
                    writer.close();
                } catch(IOException e){
                    e.printStackTrace();
                }finally{
                    //如果关流失败，那么久将writer的引用清空，这个writer就会被标记为垃圾对象
                    //强制回收，释放文件
                    //如果关流成功，也是将这个对象标记为垃圾对象
                    writer = null;
                }
            }
        }
    }
}
