package cn.commandoptionesc.ex;

public class ExDemo{
    public static void main(String[] args){
        Cat c = new Cat();
        c.eat();
        System.out.println(c.eat("猫粮"));
    }

}

abstract class Pet{
    public abstract void eat();
    public abstract String eat(String food);
    public int eat(int num){
        System.out.println("吃了" + num + "斤食物");
        return  num;
    }
}

class Cat extends Pet{

    @Override
    public void eat() {
        this.eat(1);
        System.out.println("这只猫在吃鱼");
    }

    @Override
    public String eat(String food) {
        return food;
    }
}
