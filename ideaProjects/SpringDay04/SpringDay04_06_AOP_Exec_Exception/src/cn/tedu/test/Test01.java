package cn.tedu.test;

import cn.tedu.web.UserServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServlet userServlet = context.getBean(UserServlet.class);
        userServlet.addUser();
        ((ClassPathXmlApplicationContext)context).close();
    }
}
