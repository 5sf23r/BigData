package cn.commandoptionesc.io.serial;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    //static String classroom;
    //transient修饰的属性是强制不被序列化
    private transient double height;
    private String gender;
    private static final long serialVersionUID = 234255L;
    private String no;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
