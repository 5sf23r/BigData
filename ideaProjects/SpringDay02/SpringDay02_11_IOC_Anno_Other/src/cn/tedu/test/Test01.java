package cn.tedu.test;

import cn.tedu.domain.JDBCUtils;
import cn.tedu.domain.Person;
import cn.tedu.domain.Person2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    /**
     * @PostConstruct 初始化方法
     * @PreDestroy 销毁方法
     */
    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCUtils jdbcUtils = (JDBCUtils) context.getBean("JDBCUtils");
        System.out.println(jdbcUtils);
        ((ClassPathXmlApplicationContext)context).close();
    }

    /**
     * @Lazy 懒加载
     */
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person2 p = (Person2) context.getBean("person2");
        System.out.println(p);
        ((ClassPathXmlApplicationContext)context).close();
    }


    /**
     * @Scope 单例多例
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p1 = (Person)context.getBean("person");
        System.out.println(p1);
        Person p2 = (Person)context.getBean("person");
        System.out.println(p2);
        ((ClassPathXmlApplicationContext)context).close();
    }
}
