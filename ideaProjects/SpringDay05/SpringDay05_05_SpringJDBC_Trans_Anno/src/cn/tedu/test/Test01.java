package cn.tedu.test;

import cn.tedu.domain.User;
import cn.tedu.web.UserServlet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    private ApplicationContext context = null;

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @After
    public void after(){
        ((ClassPathXmlApplicationContext)context).close();
    }

    /**
     * 声明式事务管理 - 异常机制
     */
    @Test
    public void test01(){
        UserServlet userServlet = context.getBean(UserServlet.class);
        userServlet.reigistUser(new User(0,"ttt",55));
    }

}
