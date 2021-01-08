package cn.tedu.test;

import cn.tedu.web.TestServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * SpringAOP 使用的动态代理机制
 *      如果被代理者实现过接口则用java动态代理
 *      如果被代理者没有实现过接口则用cglib动态代理
 *      可以通过如下配置强制要求使用cglib动态代理
 *          <aop:config proxy-target-class="true">
 */
public class Test01 {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestServlet testServlet = (TestServlet) context.getBean("testServlet");
        testServlet.testAdd();
        ((ClassPathXmlApplicationContext)context).close();
    }
}
