package cn.commandoptionesc.exception;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        System.out.println(m());
    }

    //代码是从上到下从左到右来一次编译运行的
    public static int m(){

        int i = 5;
        try{
            //先编译try中的return，return i++;因为++在i之后，所以先将i的值5取出来
            //将5标记为结果，然后i自增为6，准备返回的时候，发现还有一个finally需要执行
            //执行finally将i自增为7，进行返回，此时标记的返回结果是5，所以返回的也是5
            return i++;
        }catch(Exception e){
            return i++;
        }finally {
            i++;
            System.out.println("finally:" + i);
        }
    }
}
