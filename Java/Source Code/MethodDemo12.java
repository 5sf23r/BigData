package cn.commandoptionesc.method;
public class MethodDemo12{
    public static void main(String[] args){
        //StackOverflowError---栈溢出错误
        System.out.println(diGui(10000000));
        System.out.println(diGui(10));
        System.out.println(diGui2(5));

    }
    //递归方法求和
    public static int diGui(int n){
        //递归结束的条件
        if(n==1){
            return 1;
        }
        //调用方法自己本身
        return n+diGui(n-1);
        //return 10+diGui(9);
        //          9+diGui(8)
        //            8+diGui(7)
        //              7+diGui(6)
        //         ...
        //                2+diGui(1)
    }

    //递归求5的阶乘
    public static int diGui2(int n){
        //结束条件
        if(n==1){
            return 1;
        }
        return n*diGui2(n-1);
    }
}
