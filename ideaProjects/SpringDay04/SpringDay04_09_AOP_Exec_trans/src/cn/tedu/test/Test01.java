package cn.tedu.test;

import cn.tedu.domain.User;
import cn.tedu.web.UserServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServlet userServlet = context.getBean(UserServlet.class);
        User user = userServlet.queryUser(2);
        System.out.println(user);
        ((ClassPathXmlApplicationContext)context).close();
    }
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServlet userServlet = context.getBean(UserServlet.class);
        userServlet.addUser(new User(0,"iii",28));
        ((ClassPathXmlApplicationContext)context).close();
    }
}
