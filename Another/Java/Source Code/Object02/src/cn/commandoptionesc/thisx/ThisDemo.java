package cn.commandoptionesc.thisx;

public class ThisDemo {

    //static修饰的属性或者方法就是静态的
    public static void main(String[] args){

        //活跃的对象是s1，所以this代表s1
        Student s1 = new Student("Bob");
        System.out.println(s1.name);
        //此时，活跃的对象是s2，所以this代表s2
        Student s2 = new Student("Alex");
        //活跃的对象又变成s1，所以this代表s1
        s1.age =15;

    }
}
class Student{
    //姓名
    String name;
    //年龄
    int age;
    //性别
    byte gender;
    //学号
    String no;

    //在Java中，当出现变量名一致的时候，采取就近原则来使用
    //在Java中，所有的非静态属性和非静态方法都是通过对象来调用的
    //在类内用this代替当前活跃的对象来调用属性或者方法
    public Student(String name){
        this.name = name;
    }
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    public Student(String name,int age,byte gender){
        //this.name = name;
        //this.age = age;
        //表示调用Student(String,ing)
        this(name, age);
        this.gender = gender;
    }
    public Student(String name,int age,byte gender,String no){
        //this.name = name;
        //this.age = age;
        //this.gender = gender;

        //this语句
        //会自动调用本类中符合形式的构造方法
        //this(String,int,byte)--自动找--->Student(name,age,byte)
        //this语句必须在构造方法的第一行
        this(name, age, gender);
        this.no = no;
    }
}
