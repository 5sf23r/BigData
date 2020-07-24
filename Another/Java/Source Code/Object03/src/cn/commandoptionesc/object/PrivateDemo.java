package cn.commandoptionesc.object;

public class PrivateDemo {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "amy";
        p.age = 16;
    }
}

//定义一个代表人的类
class Person{

    String name;
    private int age;
}
