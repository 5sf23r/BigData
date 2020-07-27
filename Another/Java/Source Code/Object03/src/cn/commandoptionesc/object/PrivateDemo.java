package cn.commandoptionesc.object;

public class PrivateDemo {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("amy");
        p.setAge(17);
        System.out.println(p.getAge());
        System.out.println(p.getName());
    }
}

//定义一个代表人的类
class Person{

    private String name;
    //私有
    private int age;

    //提供一个方法，将要赋值的属性作为参数
    public void setAge(int age){
        if(age < 0 || age >= 150)
            return;
        this.age = age;
    }

    public int getAge(){

        return this.age;
    }

    public void setName(String name){

        this.name = name;
    }

    public String getName(){

        return this.name;
    }
}
