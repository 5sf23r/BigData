package cn.commandoptionesc.abstractx;

public class AbstractDemo {
    public static void main(String[] args) {

        /*
        //匿名内部类
        Pet p = new Pet() {
            @Override
            public void eat() {

            }
        }
        */

        /*
        //抽象类中可以有构造方法，就算添加上构造方法，也不是一个对象，依然是匿名内部类
        Animal a = new Animal() {
        };
        */

        Cat c = new Cat();
        c.name = "xiaoli";
        c.eat();
        c.eat(1);
        c.sleep();
        System.out.println(c.eat("猫粮"));
    }
}

/*
//抽象类中可以没有抽象方法
abstract class Animal{

}
*/

//抽象类中可以有构造方法
abstract class Animal{
    public Animal(){

    }
}

/*
//父类不能用final修饰，因为final修饰的类不能被继承，而抽象类一定要被继承来覆盖抽象方法
final abstract class Pet{
    public abstract void eat();
}
*/

abstract class Pet{
    String name;

    public abstract void eat();
    public abstract String eat(String food);
    public int eat(int num){
        System.out.println("吃了" + num + "斤食物");
        return num;
    }

    public void sleep(){
        System.out.println(name + "在睡觉");
    }
}


class Cat extends Pet{
    //Class 'Cat' must either be declared abstract or implement abstract method 'eat()' in 'Pet'
    //一个类继承抽象类之后，必须覆盖抽象类中的抽象方法，或者这个子类本身也是抽象类
    @Override
    public void eat(){
        System.out.println("这只猫在吃鱼");
    }

    @Override
    public String eat(String food) {
        return food;
    }
}

class Dog extends Pet{
    @Override
    public void eat() {
        System.out.println("这只狗在吃骨头");
    }

    @Override
    public String eat(String food) {
        return food;
    }
}
