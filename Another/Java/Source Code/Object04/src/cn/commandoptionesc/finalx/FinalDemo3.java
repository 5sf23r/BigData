package cn.commandoptionesc.finalx;

public class FinalDemo3 {
    public static void main(String[] args) {
        FA a = new FA();
        a.m();
        a.m(5);

        //最终方法可以继承
        FB b = new FB();
        b.m();
    }
}

class FA{

    //final修饰的方法称之为最终方法
    //最终方法不允许被重写
    //静态方法可以被final修饰
    public final static void m(){
        System.out.println("m()");
    }

    public final static void m(int i){
        System.out.println("m(int)");
    }
}

class FB extends FA{

    //最终方法不允许被重写
    //'m()' cannot override 'm()' in 'cn.commandoptionesc.finalx.FA'; overridden method is final
    /*
    public void m(){

        System.out.println("B m()");
    }
    */
}
