package cn.commandoptionesc.exception;

public class ExceptionDemo {
    public static void main(String[] args) {

        //如果异常在处理完成之后需要进行善后
        //finally:五路你出现异常与否，finally代码块都得执行一次
        try{
            System.out.println(10/0);
        }catch(Exception e){
            System.out.println("捕获异常");
        }finally{
            System.out.println("running");
        }
    }
}
