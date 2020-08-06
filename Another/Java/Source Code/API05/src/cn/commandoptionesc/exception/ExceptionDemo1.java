package cn.commandoptionesc.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionDemo1 {
    public static void main(String[] args) {

        /*
        //运行时异常
        int[] arr = new int[4];
        System.out.println(arr[5]);
        */

        /*
        //编译时异常
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.parse("2019-01-10");
        */



        int[] arr = new int[4];
        try {
            System.out.println(arr[5]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("出现一个数组下标越界异常");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf.parse("2019-01-10");
        }catch(ParseException e){
            e.printStackTrace();
        }







    }
}
