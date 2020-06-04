package cn.commandoptionesc.object;
public class ThisDemo{
    public static void main(String[] args){
        //创建对象
        Student s1=new Student();
        //this指代的对象就是s1
        System.out.println("s1:"+s1);
        Student s2=new Student(12);
        System.out.println("s2:"+s2);
        s1.study();
    }

}
//学生类
class Student{
    //属性
    String name;
    int age;
    char gender;
    //学号
    String no;

    //
    public Student(){
        System.out.println("this:"+this);
    }

    public Student(int age){
        this.age=age;
        System.out.println("this2:"+this);
    }

    //方法
    public void study(){
        //this可以代替当前类，还没有创建出来的对象
        System.out.println(this.name+"在好好学习");
        System.out.println("this3:"+this);
    }
}
