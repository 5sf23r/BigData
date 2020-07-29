package cn.commandoptionesc.staticx;

public class StaticDemo {
    public static void main(String[] args) {
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