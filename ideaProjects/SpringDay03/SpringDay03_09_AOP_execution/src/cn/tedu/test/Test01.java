package cn.tedu.test;

import cn.tedu.web.ProdServlet;
import cn.tedu.web.UserServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProdServlet prodServlet = (ProdServlet) context.getBean("prodServlet");
        prodServlet.addProd();
        prodServlet.delProd();
        ((ClassPathXmlApplicationContext)context).close();
    }
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServlet userServlet = (UserServlet) context.getBean("userServlet");
        userServlet.addUser();
        userServlet.queryUser();
        ((ClassPathXmlApplicationContext)context).close();
    }
}
