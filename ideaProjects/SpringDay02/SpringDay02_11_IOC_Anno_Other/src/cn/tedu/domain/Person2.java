package cn.tedu.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Person2 {
    public Person2(){
        System.out.println("Person2创建..");
    }
}
