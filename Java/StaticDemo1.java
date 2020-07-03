package cn.commandoptionesc.staticx;
public class StaticDemo1{
    public static void main(String[] args){
        //静态不能调用非静态方法
        //n();
        //静态可以调用非静态方法
        m();
    }
    public void n(){
    }
    public static void m(){
    }
}

