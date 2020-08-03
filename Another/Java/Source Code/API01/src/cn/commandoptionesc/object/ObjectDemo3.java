package cn.commandoptionesc.object;

import java.util.Objects;

public class ObjectDemo3 {
    public static void main(String[] args) {
        Student s1 = new Student();
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

class Student{
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
    public boolean equals(Object o) {
        //判断两个对象的地址是否一样
        if(this == o)
            return true;

        //判断参数是否为null
        if(o == null)
            return false;

        //判断类型是否一致
        if(this.getClass() != o.getClass())
            return false;

        //比较属性
        Student s  = (Student) o;

        //比较年龄是否一致
        if(this.age != s.age)
            return false;

        //比较姓名
        if(this.name == null){
            if(s.name != null)
                return false;
        }else if(!this.name.equals( s.name))
            return false;

        //比较学号
        if(this.no == null){
            if(s.no != null)
                return false;
        }else if(!this.name.equals(s.name))
            return false;
        return true;
    }
}
