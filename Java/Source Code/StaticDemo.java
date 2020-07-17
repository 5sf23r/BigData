package cn.commandoptionesc.staticx;
public class StaticDemo{
    public static void main(String[] args){
        //创建对象
        Person p=new Person();
        //赋值
        p.name="梅超风";
        p.age=30;
        p.gender='女';
         
        Person p1=new Person();
        p1.name="欧阳锋";
        p1.age=50;
        p1.gender='男';

        Person p2=new Person();
        p2.name="lili";
        p2.age=43;
        p2.gender='中';
        
        System.out.println(p2.toString());
        System.out.println(p1.toString());
        System.out.println(p.toString());
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
//Personl类
class Person{
    //属性
    String name;
    int age;
    //static修饰变量
    static char gender;


    //toString()方法
    public String toString(){
        return "name:"+name+",age:"+age+",gender:"+gender;
    }
}
