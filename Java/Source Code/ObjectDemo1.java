package cn.commandoptionesc.object;
public class ObjectDemo1{
    public static void main(String[] args){
        //创建Person类的对象
        //构造方法---用于构建对象
        Person p=new Person(16);
        System.out.println(p.age);
    }
}
//Person类
class Person{
    String name;
    int age;
    char gender;
    //构造方法---1.与类同名 2.没有类型修饰
    //java规定如果类中没有构造方法，JVM就会在底层自动添加一个无参构造
    public Person(){
    }
    //有参构造
    //构造方法允许重载
    //如果类中提供了构造方法，JVM就不会再自动添加一个无参构造
    public Person(int a){
        age=a;
    }
    //与类同名的普通方法
    public void Person(){
    }
    public void eat(){
        System.out.println(name+"在吃东西。。。");
    }
    public void sleep(){
        System.out.println("在睡觉");
    }
}

