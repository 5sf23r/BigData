package cn.tedu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class SecondAspect {
    public void before(){
        System.out.println("second前置..");
    }
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("second环绕前..");
        Object retObj = pjp.proceed();
        System.out.println("second环绕后..");
        return retObj;
    }
    public void afterReturning(){
        System.out.println("second后置..");
    }
    public void afterThrowing(){
        System.out.println("second异常..");
    }
    public void after(){
        System.out.println("second最终..");
    }
}
