package cn.commandoptionesc.object;

public class ObjectDemo2 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Sam");
        p.setAge(15);

        //当直接打印一个对象的时候，实际上底层会调用这个对象的toString方法
        System.out.println(p);
        System.out.println(p.toString());
    }
}

class Person{
    private  String name;
    private int age;

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

    @Override
    public String toString() {
        return name + "\t" + age;
    }
}
