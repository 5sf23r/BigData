package cn.tedu.aspect;

import cn.tedu.anno.PrivAnno;
import cn.tedu.enums.PrivEnum;
import cn.tedu.web.UserServlet;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class PrivAspect {


    @Around("execution(* cn.tedu.service..*(..)) && @annotation(pa)")
    public Object around(ProceedingJoinPoint pjp, PrivAnno pa) throws Throwable {
        //当前方法可以接受的角色数组
        PrivEnum[] privs = pa.value();
        //当前用户角色
        PrivEnum userPriv = UserServlet.role;
        //检查当前用户角色是否在可接受角色数组中存在
        if(Arrays.asList(privs).contains(userPriv)){
            //有，权限检查通过，直接放行
            Object retObj = pjp.proceed();
            return retObj;
        }else{
            //每有，权限检查不通过，抛出异常
            throw new RuntimeException("权限不足！");
        }
    }


//    @Around("execution(* cn.tedu.service..*(..))")
//    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        //获取目标方法
//        MethodSignature signature = (MethodSignature) pjp.getSignature();
//        Method intf_method = signature.getMethod();
//        Class<?> clz = pjp.getTarget().getClass();
//        Method inst_method = clz.getMethod(intf_method.getName(),intf_method.getParameterTypes());
//        //检查目标方法是否有@PrivAnno
//        if(inst_method.isAnnotationPresent(PrivAnno.class)){
//            //有注解 - 获取当前注解
//            PrivAnno privAnno = inst_method.getAnnotation(PrivAnno.class);// @PrivAnno({PrivEnum.USER,PrivEnum.ADMIN})
//            //当前方法可以接受的角色数组
//            PrivEnum[] privs = privAnno.value();//{PrivEnum.USER,PrivEnum.ADMIN}
//            //当前用户角色
//            PrivEnum userPriv = UserServlet.role;//PrivEnum.VISITOR
//            //检查当前用户角色是否在可接受角色数组中存在
//            if(Arrays.asList(privs).contains(userPriv)){
//                //有，权限检查通过，直接放行
//                Object retObj = pjp.proceed();
//                return retObj;
//            }else{
//                //每有，权限检查不通过，抛出异常
//                throw new RuntimeException("权限不足！");
//            }
//        }else{
//            //没注解 - 不需要权限，直接放行
//            Object retObj = pjp.proceed();
//            return retObj;
//        }
//   }
}
