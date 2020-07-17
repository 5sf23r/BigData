package cn.commandoptionesc.staticx;
public class StaticDemo1{
    public static void main(String[] args){
        
    }
}
class AA{
    public void m(){}
    public static void n(){}
}
class B extends A{
    //注解---@Override:表示下面的方法是重写方法
    @Override
    public void m(){}
    //静态方法没有重写
    //静态方法与类同级
    //重写为多态服务---多样性---对象
    //@Override
    public static void n(){}
}

