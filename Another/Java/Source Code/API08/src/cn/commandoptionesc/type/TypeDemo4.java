package cn.commandoptionesc.type;

import java.util.ArrayList;
import java.util.List;

public class TypeDemo4 {

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        List<Apple> apples = new ArrayList<>();

        //假设向各个集合中添加了很多元素
        //泛型没有向上造型
        forEachAnimal(cats);
        forEachAnimal(dogs);
        //forEachAnimal(apples);
    }

    //提供一个方法来遍历元素类型是动物的集合
    //泛型的上限就是Animal
    //此时传入的参数就不能超过Animal，可以传入Animal及其子类对象
    //public static void forEachAnimal(List <<? extends Animal> extends Object> animals){
    public static void forEachAnimal(List<? extends Animal> animals){
        for(Animal animal : animals){
            System.out.println(animal);
        }
    }
}

class Animal{
}
class Cat extends Animal{

}
class Dog extends Animal{

}
class Apple{

}