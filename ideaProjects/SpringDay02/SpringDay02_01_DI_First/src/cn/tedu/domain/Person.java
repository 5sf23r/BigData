package cn.tedu.domain;

public class Person {

    private String name;
    private int age;

    public void eat(){
        System.out.println("吃..");
    }
    public void say(){
        System.out.println("说..");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
