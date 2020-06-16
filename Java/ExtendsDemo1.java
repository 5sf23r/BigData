package cn.commandoptionesc.extendsx;
public class ExtendsDemo1{
    public static void main(String[] args){
        
    }
}

//
class A{
    //私有化的方法  对子类不可见
    private void m(){
        
    }
}

class B extends A{
    //新方法
    int m(){
        return 1;
    }
}
