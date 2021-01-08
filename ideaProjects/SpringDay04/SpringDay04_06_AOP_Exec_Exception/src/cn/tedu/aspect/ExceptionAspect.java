package cn.tedu.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;


@Component
@Aspect
public class ExceptionAspect {

    private static Logger logger = Logger.getLogger(ExceptionAspect.class);

    @AfterThrowing(value="execution(* cn.tedu.service..*(..))",throwing = "e")
    public void afterThrowing(JoinPoint jp,Throwable e){
        //获取目标对象
        Object target = jp.getTarget();
        Class clz = target.getClass();
        //获取目标方法
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        //记录日志
        logger.info("在["+clz+"]类中的["+method+"]方法中发生了["+e+"]异常");
    }
}
