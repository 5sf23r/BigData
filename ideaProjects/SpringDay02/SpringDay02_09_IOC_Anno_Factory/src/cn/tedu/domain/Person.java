package cn.tedu.domain;

import org.springframework.stereotype.Component;

public class Person {
    public Person(String name){
        System.out.println("Person 创建了.."+name);
    }
}
