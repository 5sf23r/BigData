package cn.tedu.aspect;

import cn.tedu.anno.Trans;
import cn.tedu.utils.TransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransAspect {
    @Around("execution(* cn.tedu.service..*(..)) && @annotation(ts)")
    public Object around(ProceedingJoinPoint pjp,Trans ts) throws Throwable {
        try {
            TransactionManager.startTran();
            Object retObj = pjp.proceed();
            TransactionManager.commitTran();
            return retObj;
        } catch (Exception e) {
            TransactionManager.rollbackTran();
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            TransactionManager.relase();
        }
    }
}
