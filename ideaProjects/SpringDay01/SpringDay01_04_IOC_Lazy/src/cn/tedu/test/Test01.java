package cn.tedu.test;

import cn.tedu.domain.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    /**
     * 懒加载机制
     *  开启了懒加载的bean将不会再容器初始化时创建
     *  而是将对象创建的时机延后到了第一次使用到该bean时
     *  创建出对象后保存到Map中，后续获取不会再创建bean，而是直接从Map中获取
     *  懒加载只是将单例对象的创建时机延后了，该对象仍然是单例的
     *
     *  ！！！多例对象配置懒加载没有意义
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p1 = (Person) context.getBean("person");
        System.out.println(p1);
        Person p2 = (Person) context.getBean("person");
        System.out.println(p2);
        ((ClassPathXmlApplicationContext)context).close();
    }
}
