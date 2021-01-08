package cn.tedu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 注解方式开发AOP
 */
@Component
@Aspect
public class FirstAspect {
    @Before("execution(* cn.tedu.service..*(..))")
    public void myBefore(){
        System.out.println("前置通知..");
    }

    @Around("execution(* cn.tedu.service..*(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前..");
        Object retObj = pjp.proceed();
        System.out.println("环绕后..");
        return retObj;
    }

    @AfterReturning(value="execution(* cn.tedu.service..*(..))",returning = "retObj")
    public void myAfterReturning(Object retObj){
        System.out.println("后置通知.."+retObj);
    }

    @AfterThrowing(value="execution(* cn.tedu.service..*(..))",throwing="e")
    public void myAfterThrowing(Throwable e){
        System.out.println("异常通知.."+e);
    }

    @After("execution(* cn.tedu.service..*(..))")
    public void myAfter(){
        System.out.println("最终通知..");
    }

}
