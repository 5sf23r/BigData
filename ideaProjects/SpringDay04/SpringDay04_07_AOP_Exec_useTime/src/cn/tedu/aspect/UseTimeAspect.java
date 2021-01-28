package cn.tedu.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class UseTimeAspect {

    private static Logger logger = Logger.getLogger(UseTimeAspect.class);

    @Around("execution(* cn.tedu.service..*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //开始时间
        long begin = System.currentTimeMillis();
        //--调用目标方法
        Object retObj = pjp.proceed();
        //结束时间
        long end = System.currentTimeMillis();

        //用时 = 结束时间 - 开始时间
        long useTime = end - begin;

        //记录日志
        Class clz = pjp.getTarget().getClass();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        logger.debug("["+clz+"]类中["+method+"]方法执行耗时["+useTime+"]毫秒");

        //--返回返回值
        return retObj;
    }
}
