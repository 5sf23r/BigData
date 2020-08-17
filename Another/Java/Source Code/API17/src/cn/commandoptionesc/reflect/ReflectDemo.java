package cn.commandoptionesc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class ReflectDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        Student s1 = new Student();
        s1.setAge(17);
        s1.setName("Alex");
        s1.setGender("male");

        Car c1 = new Car();
        c1.setColor("red");
        c1.setPrice(100000);

        Driver d1 = new Driver("Helen",25,"G23434");

        Student s2 = (Student) clone(s1);
        System.out.println(s2);
        Car c2 = (Car) clone(c1);
        System.out.println(c2);
        Driver d2 = (Driver) clone(d1);
        System.out.println(d2);
    }
    //参数类型不确定的情况下，创建一个一模一样的对象
    public static Object clone(Object o) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        //获取参数类型
        Class c1z = o.getClass();
        //获取构造函数
        Constructor c = c1z.getDeclaredConstructors()[0];
        c.setAccessible(true);
        //获取构造函数中参数的类型
        Class[] ps = c.getParameterTypes();
        //存储构造函数的参数
        Object[] os = new Object[ps.length];
        for(int i = 0;i < ps.length;i++){
            if(ps[i] == boolean.class) {
                os[i] = false;
            }else if(ps[i] == char.class) {
                os[i] = '\u0000';
            }else if(ps[i].isPrimitive()){
                os[i] = (byte)  0;
            }else{
                os[i] = null;
            }
        }

        //构造对象
        Object newObj = c.newInstance(os);
        //获取对象所有的属性
        Field[] fs = c1z.getDeclaredFields();
        for(Field f:fs){
            //暴力破解
            f.setAccessible(true);
            //判断属性是否是final修饰
            if((f.getModifiers() & Modifier.FINAL) == Modifier.FINAL)
                continue;
            //从传入的对象中将属性值获取出来
            Object value = f.get(o);
            //赋值给新创建的对象
            f.set(newObj,value);
        }
        return newObj;
    }
}

class Driver{
    private String name;
    private int age;
    private String no;

    public Driver(String name, int age, String no) {
        this.name = name;
        this.age = age;
        this.no = no;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", no='" + no + '\'' +
                '}';
    }
}

class Student{

    private String name;
    private int age;
    private String gender;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
class Car{
    private String color;
    private double price;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
