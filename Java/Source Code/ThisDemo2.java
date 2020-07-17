package cn.commandoptionesc.object;
public class ThisDemo2{
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
    public Student(int age){
        this.age=age;
    }

    //
    public Student(int age,String name){
        //System.out.println("this:"+this);
        //this.age=age;
        //this()---this语句---在当前构造方法中调用奔雷其他形式的构造方法
        //调用构造方法的age
        this(age);
        this.name=name;
    }

    public Student(int age,char gender,String name){
        // this.name=name;
        //this.age=age;
        this(age,name);
        this.gender=gender;
        //System.out.println("this2:"+this);
    }

    //方法
    public void study(){
        //this可以代替当前类，还没有创建出来的对象
        //System.out.println(this.name+"在好好学习");
        //System.out.println("this3:"+this);
    }
}
