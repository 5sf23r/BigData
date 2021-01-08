package cn.tedu.test;

import cn.tedu.web.UserServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    /**
     *  SpringIOC/DI + 接口 实现软件分层解耦
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServlet userServlet = (UserServlet) context.getBean("userServlet");
        userServlet.registUser();
        ((ClassPathXmlApplicationContext)context).close();
    }
}
