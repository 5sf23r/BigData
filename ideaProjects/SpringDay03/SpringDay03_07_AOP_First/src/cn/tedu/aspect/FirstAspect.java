package cn.tedu.aspect;

import org.springframework.stereotype.Component;

@Component
public class FirstAspect {
    public void myFirst(){
        System.out.println("first...");
    }
}