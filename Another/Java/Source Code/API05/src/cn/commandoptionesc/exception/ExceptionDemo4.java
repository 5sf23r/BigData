package cn.commandoptionesc.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemo4 {
    public static void main(String[] args) throws FileNotFoundException {

        //当调用这个方法的时候，会发现这个方法有异常抛出，需要处理
        try {
            //readTxt("文件路径");
            String str = readTxt(null);
            System.out.println(str);
        }catch (FileNotFoundException | FileFormatException2 e){
            System.out.println(e.getMessage());
        }catch(NullPointerException e){
            //System.out.println("捕获了一个空指针异常");
            //打印栈轨迹
            e.printStackTrace();
        }
        System.out.println("finish");
    }

    public static String readTxt(String path) throws FileNotFoundException,FileFormatException2,NullPointerException{

        //判断参数是否为空
        if(path == null)
            throw new NullPointerException();
        if(path.startsWith("H:\\")) {
            //需要反馈这个问题，将问题以异常对象形式来反馈
            throw new FileNotFoundException();
        }
        if(!path.endsWith(".txt")){
            throw new FileFormatException2("需要一个txt文件，但是传入的不是tet文件");
        }
        return "读取成功啦";
    }
}


class FileFormatException2 extends IOException {

    public FileFormatException2(){

    }
    public FileFormatException2(String msg){
        super(msg);
    }

}