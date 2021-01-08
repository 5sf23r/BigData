package cn.tedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class UserServiceImplCglibProxy {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService = null;

    @Bean("userService")
    public UserService newProxy(){
        //1.创建增强器
        Enhancer enhancer = new Enhancer();
        //2.指定要实现的接口们
        enhancer.setInterfaces(userService.getClass().getInterfaces());
        //3.指定要继承的父类
        enhancer.setSuperclass(userService.getClass());
        //4.指定回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy mp) throws Throwable {
                try{
                    System.out.println("记录日志");
                    System.out.println("控制权限");
                    System.out.println("开启事务");
                    Object retObj = method.invoke(userService,args);
                    System.out.println("提交事务");
                return retObj;
                }catch (Exception e){
                    System.out.println("回滚事务");
                    throw e;
                }
            }
        });
        //5.创建代理者
        UserService proxy = (UserService) enhancer.create();
        //6.返回代理者
        return proxy;
    }
}
