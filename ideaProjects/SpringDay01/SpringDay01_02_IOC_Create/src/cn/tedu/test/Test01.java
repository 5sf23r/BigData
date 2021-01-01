package cn.tedu.test;

import cn.tedu.domain.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    /**
     * SpringIOC创建对象方式4 - Spring工厂
     * <bean id="person" class="cn.tedu.factory.PersonSpringFactory"></bean>
     */
    @Test
    public void test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p = (Person) context.getBean("person");
        System.out.println(p);
        ((ClassPathXmlApplicationContext)context).close();
    }


    /**
     * SpringIOC创建对象方式3 - 实例工厂
     *  <bean id="personInstanceFactory" class="cn.tedu.factory.PersonInstanceFactory"></bean>
     *  <bean id="person" factory-bean="personInstanceFactory" factory-method="getInstance"></bean>
     */
    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p = (Person) context.getBean("person");
        System.out.println(p);
        ((ClassPathXmlApplicationContext)context).close();
    }

    /**
     * SpringIOC创建对象方式2 - 静态工厂
     * <bean id="person" class="cn.tedu.factory.PersonStaticFactory" factory-method="getInstance"></bean>
     */
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p = (Person) context.getBean("person");
        System.out.println(p);
        ((ClassPathXmlApplicationContext)context).close();
    }

    /**
     * SpringIOC创建对象方式1 - 反射创建对象
     *  bean必须有无参构造才可以
     */
    @Test
    public void test01() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p = (Person) context.getBean("person");
        System.out.println(p);
        ((ClassPathXmlApplicationContext)context).close();
    }
}
