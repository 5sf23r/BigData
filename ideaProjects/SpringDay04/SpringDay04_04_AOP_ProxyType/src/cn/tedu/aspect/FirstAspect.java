package cn.tedu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class FirstAspect {
    public void before(){
        System.out.println("first前置..");
    }
}
