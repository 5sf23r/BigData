package pojo;
/*
* pojo:指的就是一个简单的javaBean
* javaBean：指的是一个java类中具有以下基本的结构：
*       1. 成员变量
*       2. 构造方法
*       3. getter和setter
*       4. toString
* 通常：在pojo包中，存在的javaBean，我们称之为：对象模型
* */
public class Person {
    //1. 成员变量
    private String name;
    private int age;
    private String addr;

    public Person(String name, int age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    //2. 构造方法
    public Person() {
    }

    //3. getter和setter
    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    public String getAddr() {

        return addr;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public void setAddr(String addr) {

        this.addr = addr;
    }

    //4. javaBean的toString
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
