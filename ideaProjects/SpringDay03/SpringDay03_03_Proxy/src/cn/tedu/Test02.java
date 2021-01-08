package cn.tedu;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Star{
    public void qianming();
    public void chifan();
}

class FBB implements Star{
    public void qianming(){
        System.out.println("fbb签名..");
    }
    public void chifan(){
        System.out.println("fbb吃饭..");
    }
    public void shufa(){
        System.out.println("fbb写书法..");
    }
}

public class Test02 {

    /**
     * 动态代理 - cglib动态代理
     *  优点：基于继承实现代理，无论方法是否属于接口都可以代理
     *  缺点：不是java原生的，需要导如第三方包才能使用
     */
    @Test
    public void test03(){
        FBB fbb = new FBB();
        //1.创建增强器
        Enhancer enhancer = new Enhancer();
        //2.指定要实现的接口们，不是必须的
        enhancer.setInterfaces(fbb.getClass().getInterfaces());
        //3.指定父类，必须的
        enhancer.setSuperclass(fbb.getClass());
        //4.指定回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy mp) throws Throwable {
                System.out.println("你谁啊？");
                Object retObj = method.invoke(fbb,args);
                System.out.println("记录一下..");
                return retObj;
            }
        });
        //5.创建代理者
        FBB proxy = (FBB) enhancer.create();

        //6.有事找代理，不能直接找FBB
        proxy.qianming();
        proxy.chifan();
        proxy.shufa();
    }

    /**
     * 动态代理 - java动态代理
     *  优点：代理代码只需要写一遍就可以对多个方法进行代理
     *  缺点：基于接口实现代理，如果方法不属于任何接口，则无法代理
     */
    @Test
    public void test02(){
        //被代理者 - 范冰冰
        FBB fbb = new FBB();

        //代理者 - 助理
        Star proxy = (Star) Proxy.newProxyInstance(
                //类加载器
                FBB.class.getClassLoader(),
                //要实现的接口们
                FBB.class.getInterfaces(),
                //回调函数 - 代理者执行的逻辑
                new InvocationHandler() {
                    /**
                     * @param proxy 代理者 - 助理
                     * @param method 被调用的方法
                     * @param args 被调用的方法的参数
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("你谁啊？");
                        Object retuObj = method.invoke(fbb, args);
                        System.out.println("记录一下..");
                        return retuObj;
                    }
                }
        );

        //有事找助理，不能找范冰冰
        proxy.qianming();
        proxy.chifan();
        //proxy.shufa();
    }

    /**
     * 静态代理
     *  优点：好理解
     *  缺点：所有方法都要实现 代码存在大量重复
     */
    @Test
    public void test01(){
        FBB fbb = new FBB();

        class ZuLi implements Star{
            @Override
            public void qianming() {
                System.out.println("你谁啊？");
                fbb.qianming();
                System.out.println("记录一下..");
            }
            @Override
            public void chifan() {
                System.out.println("你谁啊？");
                fbb.chifan();
                System.out.println("记录一下..");
            }
        }

        ZuLi proxy = new ZuLi();

        proxy.qianming();
        proxy.chifan();
    }
}
