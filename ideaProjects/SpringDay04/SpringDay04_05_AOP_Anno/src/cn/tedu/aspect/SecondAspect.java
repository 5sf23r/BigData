package cn.tedu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 注解方式AOP @Pointcut的使用
 */
@Component
@Aspect
public class SecondAspect {

    @Pointcut("execution(* cn.tedu.service..*(..))")
    public void mx(){
    }

    @Before("mx()")
    public void myBefore(){
        System.out.println("second前置通知..");
    }

    @Around("mx()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("second环绕前..");
        Object retObj = pjp.proceed();
        System.out.println("second环绕后..");
        return retObj;
    }

    @AfterReturning(value="mx()",returning = "retObj")
    public void myAfterReturning(Object retObj){
        System.out.println("second后置通知.."+retObj);
    }

    @AfterThrowing(value="mx()",throwing="e")
    public void myAfterThrowing(Throwable e){
        System.out.println("second异常通知.."+e);
    }

    @After("mx()")
    public void myAfter(){
        System.out.println("second最终通知..");
    }

}
