package cn.commandoptionesc.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemo2 {
    public static void main(String[] args) throws FileNotFoundException {

        //当调用这个方法的时候，会发现这个方法有异常抛出，需要处理
        try {
            //readTxt("文件路径");
            String str = readTxt(null);
            System.out.println(str);
        }catch (FileNotFoundException e) {
            //打印栈轨迹
            e.printStackTrace();
        }catch(FileFormatException e){
            System.out.println(e.getMessage());
        }catch(NullPointerException e){
            System.out.println("捕获了一个空指针异常");
        }
        System.out.println("finish");
    }

    public static String readTxt(String path) throws FileNotFoundException,FileFormatException,NullPointerException{

        //判断参数是否为空
        if(path == null)
            throw new NullPointerException();



        //路径不存在
        //模拟：如果盘符是以H开头，表示路径不存在
        if(path.startsWith("H:\\")) {
            //需要反馈这个问题，将问题以异常对象形式来反馈
            throw new FileNotFoundException();
        }

        //如果传入的路径对应的文件不是TXT文件
        if(!path.endsWith(".txt")){
            throw new FileFormatException("需要一个txt文件，但是传入的不是tet文件");
        }
        return "读取成功啦";
    }
}


class FileFormatException extends IOException {

    //private String message;

    public FileFormatException(){

    }
    public FileFormatException(String msg){
        //this.message = msg;
        super(msg);
    }

    /*
    @Override
    public String getMessage() {
        return message;
    }
    */
}