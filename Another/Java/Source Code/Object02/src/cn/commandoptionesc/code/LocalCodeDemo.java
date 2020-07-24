package cn.commandoptionesc.code;

public class LocalCodeDemo {
    public static void main(String[] args) {

        //在方法中用{}括起来的代码称之为局部代码块
        {
            //限制了变量的使用范围，缩短了变量的生命周期
            //提高了栈内存的利用率
            int j = 5;
            int i = 7;
            System.out.println(i+j);
        }
        System.out.println("running");
    }
}
