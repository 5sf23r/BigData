package cn.commandoptionesc.collection;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {

        TreeSet<String> set = new TreeSet<>();

        set.add("r");
        set.add("a");
        set.add("g");
        set.add("i");
        set.add("r");

        System.out.println(set);

        TreeSet<Student> set1 = new TreeSet<>();
        set1.add(new Student("Bob",17,9));
        set1.add(new Student("Amy",18,70));
        set1.add(new Student("Tom",16,85));
        set1.add(new Student("Sam",16,60));
        for(Student s : set1){
            System.out.println(s);
        }
    }
}

class Student implements Comparable<Student>{
    private String name;
    private int age;
    private int score;

    public Student(String name,int age,int score){
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';

    }


    //决定排序顺序
    //需要指定要根据哪个属性进行排序
    //根据分数降序排序
    //降序排序：o - this
    //升序排序：this - o
    @Override
    public int compareTo(Student o) {
        //根据分数降序排序
        //return o.score - this.score;
        //根据年龄升序排序
        //排序的时候，如果值相减为0，则会认为是重复元素
        //Set不会存储重复的元素
        return this.age - o.age;
    }
}