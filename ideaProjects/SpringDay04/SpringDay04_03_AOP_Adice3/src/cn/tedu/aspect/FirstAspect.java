package cn.tedu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class FirstAspect {

    public void before(){
        System.out.println("first前置..");
    }
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("first环绕前..");
        Object retObj = pjp.proceed();
        System.out.println("first环绕后..");
        return retObj;
    }
    public void afterReturning(){
        System.out.println("first后置..");
    }
    public void afterThrowing(){
        System.out.println("first异常..");
    }
    public void after(){
        System.out.println("first最终..");
    }

}
