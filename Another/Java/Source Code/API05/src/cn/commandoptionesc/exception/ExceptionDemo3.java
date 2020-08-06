package cn.commandoptionesc.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemo3 {
    public static void main(String[] args) throws FileNotFoundException {

        try {
            //readTxt("文件路径");
            String str = readTxt(null);
            System.out.println(str);
        }catch (Exception e){
            //System.out.println("捕获了一个空指针异常");
            e.printStackTrace();
        }
        System.out.println("finish");
    }

        public static String readTxt(String path) throws FileNotFoundException,FileFormatException1,NullPointerException{

        if(path == null)
            throw new NullPointerException();
        if(path.startsWith("H:\\")) {
            throw new FileNotFoundException();
        }
        if(!path.endsWith(".txt")){
            throw new FileFormatException1("需要一个txt文件，但是传入的不是tet文件");
        }
        return "读取成功啦";
    }
}


class FileFormatException1 extends IOException {

       public FileFormatException1(){
    }
    public FileFormatException1(String msg){
        super(msg);
    }
}