package cn.commandoptionesc.staticx;

public class StaticDemo {
    public static void main(String[] args) {

        //静态变量要求在类加载的时候就得初始化，静态方法是在调用的时候才执行初始化
        //Modifier "static" not allowed here
        //static int i = 5;
        Student s1 = new Student();
        s1.name = "Bob";
        s1.age = 15;
        s1.grade = "四年级";

        Student s2 = new Student();
        s2.name = "Alex";
        s2.age = 16;
        s2.grade = "五年级";

        s1.toStr();
        s2.toStr();

        //Non-static method 'printName(cn.commandoptionesc.staticx.Student)' cannot be referenced from a static context
        //printName(s1);
        //this.printName(s1);
    }
    public void printName(Student s){
        System.out.println(s.name);
    }
}

class Student{
    String name;
    int age;
    static String grade;

    public void toStr(){

        System.out.println(name + "\t" + age + "\t" + grade);
    }
}