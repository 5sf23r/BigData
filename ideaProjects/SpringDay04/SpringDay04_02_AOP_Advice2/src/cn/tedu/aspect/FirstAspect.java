package cn.tedu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 五大通知类型
 */
@Component
public class FirstAspect {

    /**
     * 最终通知
     *      在目标方法执行之后一定执行的通知，无论目标方法是正常结束还是异常结束
     *      可以通过JoinPoint获取目标对象目标方法相关信息
     */
    public void myAfter(JoinPoint jp){
        //--获取目标对象
        Object target = jp.getTarget();
        //--获取目标方法
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();

        System.out.println("最终通知.."+target+".."+method+"..");
    }


    /**
     * 异常通知
     *      在目标方法抛出异常时执行的通知
     *      可以通过JoinPoint获取目标对象目标方法相关信息
     */
    public void myAfterThrowing(JoinPoint jp,Throwable e){
        //--获取目标对象
        Object target = jp.getTarget();
        //--获取目标方法
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();

        System.out.println("异常通知.."+target+".."+method+".."+e);
    }

    /**
     * 后置通知
     *      在目标方法成功执行之后执行的通知
     *      可以通过JoinPoint获取目标对象目标方法相关信息
     *      可以接收目标方法执行之后返回的返回值
     */
    public void myAfterReturning(JoinPoint jp,Object retObj){
        //--获取目标对象
        Object target = jp.getTarget();
        //--获取目标方法
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();

        System.out.println("后置通知.."+target+".."+method+".."+retObj);
    }

    /**
     * 环绕通知
     *      可以通过ProceedingJoinPoint获取目标对象目标方法相关信息
     *      控制目标方法是否执行
     *      在目标方法执行之前和之后执行代码进行增强
     *      控制是否返回返回值
     *      改变返回值
     */
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知..目标方法执行之前..");
        Object retObj = pjp.proceed();//调用目标方法
        System.out.println("环绕通知..目标方法执行之后..");
        return retObj;
    }

    /**
     * 前置通知
     *      在目标方法执行之前执行代码进行增强
     *      可以通过JoinPoint获取目标对象目标方法相关信息
     */
    public void myBefore(JoinPoint jp){
        //--获取目标对象
        Object target = jp.getTarget();
        //--获取目标方法
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();

        System.out.println("前置通知.."+target+".."+method);
    }
}
