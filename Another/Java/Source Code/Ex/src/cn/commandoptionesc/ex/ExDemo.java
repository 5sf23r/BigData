package cn.commandoptionesc.ex;

import java.io.File;
import java.io.FileNotFoundException;

public class ExDemo {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            String msg = readTxt("~/Documents/ex.txt");
        }catch (FileNotFoundException e){
            //处理问题
        }
    }
    public static String readTxt(String path)throws FileNotFoundException{
        //路径不存在
        if(判断路径是否存在)
            //将问题包装成一个异常对象来抛出
            throw new FileNotFoundException();
        return "读取到的内容";
    }
}
