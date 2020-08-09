package cn.commandoptionesc.file;

import java.io.File;

public class FileExer1 {
    public static void main(String[] args) {

        File file = new File("../Other/ex");
        deleteFile(file);
    }
    public static void deleteFile(File file){

        //判断传入的参数是否为空
        if(file == null){
            throw new NullPointerException("传入的参数不能为空！！！");
        }

        //判断是否是一个目录
        if(file.isDirectory()){
            //如果是目录，那么需要获取子目录和子文件
            File[] files = file.listFiles();
            //遍历这个数组，再来一个个的一次处理
            for(File f : files){
                deleteFile(f);
            }
        }

        //无论是文件还是目录，都需要删除
        file.delete();
    }
}
