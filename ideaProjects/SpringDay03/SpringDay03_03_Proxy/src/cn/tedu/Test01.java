package cn.tedu;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface 动物{
    public void 吃();
    public void 叫();
}

class 狗 implements 动物{
    public void 吃(){
        System.out.println("狗在么么么的吃..");
    }
    public void 叫(){
        System.out.println("狗在汪汪汪的叫..");
    }
    public void 看家(){
        System.out.println("狗在看家..");
    }
}

public class Test01 {
    /**
     * 改造不喜欢的方法 - 代理设计模式 - 动态代理 - cglib动态代理
     */
    @Test
    public void test05(){
        狗 dog = new 狗();
        //1.创建增强器
        Enhancer enhancer = new Enhancer();
        //2.指定要实现接口们 - 不是必须的
        enhancer.setInterfaces(dog.getClass().getInterfaces());
        //3.指定要继承的父类 - 必须的
        enhancer.setSuperclass(dog.getClass());
        //4.指定回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy mp) throws Throwable {
                if("叫".equals(method.getName())){
                    System.out.println("狗在呵呵呵的叫..");
                    return null;
                }else{
                    Object retObj = method.invoke(dog,args);
                    return retObj;
                }
            }
        });
        //5.创建代理对象
        狗 proxy = (狗) enhancer.create();

        //6.有事找代理，不要找dog
        proxy.吃();
        proxy.叫();
        proxy.看家();
    }


    /**
     * 改造不喜欢的方法 - 代理设计模式 - 动态代理 - java动态代理
     */
    @Test
    public void test04(){
        狗 dog = new 狗();
        动物 proxy = (动物) Proxy.newProxyInstance(
            dog.getClass().getClassLoader(),
            dog.getClass().getInterfaces(),
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if("叫".equals(method.getName())){
                        System.out.println("狗在嘻嘻嘻的叫...");
                        return null;
                    }else{
                        return method.invoke(dog,args);
                    }
                }
            }
        );
        proxy.吃();
        proxy.叫();
    }


    /**
     * 改造不喜欢的方法 - 代理设计模式 - 静态代理
     */
    @Test
    public void test03(){
        狗 dog = new 狗();

        class 代理狗 implements 动物{

            @Override
            public void 吃() {
                dog.吃();
            }

            @Override
            public void 叫() {
                System.out.println("狗在哈哈哈的叫..");
            }
        }

        代理狗 proxy = new 代理狗();
        proxy.吃();
        proxy.叫();
    }


    /**
     * 改造不喜欢的方法 - 装饰者设计模式
     */
    @Test
    public void test02(){
        class 装饰狗 implements 动物{
            private 动物 ani;
            public 装饰狗(动物 ani){
                this.ani = ani;
            }
            @Override
            public void 吃() {
                ani.吃();
            }
            @Override
            public void 叫() {
                System.out.println("狗在咩咩咩的叫..");
            }
        }
        狗 dog = new 狗();
        装饰狗 dog2 = new 装饰狗(dog);
        dog2.吃();
        dog2.叫();
    }


    /**
     * 改造不喜欢的方法 - 继承重写
     */
    @Test
    public void test01(){

        class 继承狗 extends 狗{
            @Override
            public void 叫() {
                System.out.println("狗在喵喵喵的叫..");
            }
        }

        //狗 dogx = new 狗();

        狗 dog = new 继承狗();
        dog.吃();
        dog.叫();
    }
}
