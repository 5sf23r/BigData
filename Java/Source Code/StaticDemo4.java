package cn.commandoptionesc.staticx;
public class StaticDemo4{
    public static void main(String[] args){
        new SD();
    }
}
class SD1{
    static{
        System.out.println("静态代码块1");
    }
    {
        System.out.println("构造代码块1");
    }
}
class SD extends SD1{
    static int i;
    //静态代码块
    //随着类的加载而加载但是只加载一次，与类同级
    static{
        //静态变量
        i = 9;
        System.out.println("静态代码块");
    }
    {
        System.out.println("构造代码块");
    }
    public SD(){
        System.out.println("无参构造");
    }
}



