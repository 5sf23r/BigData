package cn.commandoptionesc.extendsx;

public class ExtendsDemo4 {
    public static void main(String[] args) {
        B b = new B();
        b.m();
    }
}

//
class A {
    public A(int i){

    }
    public void m(){
        System.out.println("A ");
  }
}

//
class B extends A{
    //如果在子类中没有手动指定，那么在子类的构造方法中
    //默认添加一个无参super()调用父类中对应形式的构造方法
    public B(){
        super(5);
    }

    public B(int i){
        //先创建一个父类对象，然后才能在子类中调用父类对象中的属性或者方法
        super(i);
        System.out.println(i);
    }

    @Override
    public void m() {
        super.m();
        System.out.println("B");
    }
}
