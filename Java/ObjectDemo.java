package cn.commandoptionesc.object;
public class ObjectDemo{
    public static void main(String[] args){
        //创建Person类的对象
        //构造方法---用于构建对象
        Person p=new Person();
        p.age=10;
        p.name="lili";
        p.gender='女';
        //输出
        System.out.println(p.age);
        p.eat();
        //基本类型，传入的就是值的拷贝
        //m(p.age);
        //传入的是引用数据类型，就是对象的地址值的拷贝
        n(p);
        //0
        System.out.println(p.age);
    }
    public static void m(int i){
        i++;
    }
    //对象地址值的拷贝
    public static void n(Person p){
        p.age=10;
        p.eat();
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
    public Person(int age){
        
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

