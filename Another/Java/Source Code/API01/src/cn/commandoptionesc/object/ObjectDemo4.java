package cn.commandoptionesc.object;

import java.util.Objects;

public class ObjectDemo4 {
    public static void main(String[] args) {
        Student1 s1 = new Student1();
        s1.setName(new String("Sam"));
        s1.setAge(15);
        s1.setNo("gwer1234");

        Student s2 = new Student();
        s2.setName(new String("Sam"));
        s2.setAge(15);
        s2.setNo("gwer1234");

        //比较的是地址是否一样
        System.out.println(s1.equals(s2));
    }
}

class Student1 {
    private String name;
    private int age;
    private String no;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", no='" + no + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student1 student1 = (Student1) o;
        return age == student1.age &&
                name.equals(student1.name) &&
                no.equals(student1.no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, no);
    }
}