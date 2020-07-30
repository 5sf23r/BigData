package cn.commandoptionesc.finalx;

public class FinalDemo4 {
    public static void main(String[] args) {
        A1 a = new A1();
        a.m();
    }
}

//用final修饰的类称之为最终类
final class A1{

    public void m(){
        System.out.println("m()");
    }
}

//最终类不能被继承
//Cannot inherit from final 'cn.commandoptionesc.finalx.A1'
/*
class A2 extends A1{


}
 */
