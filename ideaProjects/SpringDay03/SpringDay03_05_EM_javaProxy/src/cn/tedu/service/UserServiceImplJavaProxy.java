package cn.tedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Component
public class UserServiceImplJavaProxy {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService = null;

    @Bean("userService")
    public UserService newProxy(){
        UserService proxy = (UserService)Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
                }
        );
        return proxy;
    }
}
