package cn.commandoptionesc.type;

public class TypeDemo2 {
    public static void main(String[] args) {

        Demo<String,Double> d1 = new Demo<>();
        d1.set("a");
    }
}

//将位置的属性的类型以泛型的形式来体现
//泛型的命名只要符合标识符的命名即可，但是通常状态下，一般使用1个大写字母来表示泛型
class Demo<T,A>{

    private  T t;
    private  A a;

    public T get(){
        return t;
    }

    public void set(T t){
        this.t = t;
    }


}
