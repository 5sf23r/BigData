package cn.commandoptionesc.io.system;

import java.io.IOException;

public class SystemDemo {
    public static void main(String[] args) throws IOException {

        //标准输入流
        //Scanner
        int i = System.in.read();
        //标准输出流和标准错误流在底层实现上一模一样
        //只有颜色不一样
        //实际过程中，正常结果用标准输入流来打印
        //错误结果或者异常信息一般使用的是标准错误流
        //标准输出流
        System.out.println(i);
        //标准错误流
        System.out.println(i);

    }
}
