package cn.tedu.test;

import cn.tedu.domain.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    /**
     * 注解方式实现工厂生产bean
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p = (Person) context.getBean("person");
        System.out.println(p);
        ((ClassPathXmlApplicationContext)context).close();
    }
}
