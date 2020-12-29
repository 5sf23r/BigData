package cn.tedu.test;

import cn.tedu.domain.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    /**
     * 别名标签
     *  可以通过别名标签为bean的id起一个别名，此后除了可以通过别名指代id
     *  <alias name="person" alias="pers"></alias>
     */
    @Test
    public void test05(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Person p = (Person) context.getBean("person");
        Person p = (Person) context.getBean("pers");
        System.out.println(p);
        ((ClassPathXmlApplicationContext)context).close();
    }

    /**
     * 获取对象的方式
     *  通过id获取bean
     *      如果找不到，抛异常NoSuchBeanDefinitionException
     *      如果找到唯一的，返回对象
     *      因为id不重复，不可能找到多个
     *  通过class获取bean
     *      如果找不到,抛出异常NoSuchBeanDefinitionException
     *      如果找到唯一，返回对象
     *      如果找到多个，抛出异常NoUniqueBeanDefinitionException
     */
    @Test
    public void  test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取对象方式1：通过id获取
        //Person p = (Person)context.getBean("person");
        //p.eat();
        //p.say();
        //获取对象方式2：通过class获取
        Person p = context.getBean(Person.class);
        p.eat();
        p.say();

        ((ClassPathXmlApplicationContext)context).close();
    }


    /**
     * 默认情况下多次获取同一个id的bean得到的是同一个对象
     * 不可以配置id相同的bena
     * 可以配置多个id不同但class相同的bean
     */
    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p1 = (Person) context.getBean("person");
        Person p2 = (Person) context.getBean("person");
        System.out.println(p1);
        System.out.println(p2);
        ((ClassPathXmlApplicationContext)context).close();
    }

    /**
     * SpringIOC方式创建并管理bean
     */
    @Test
    public void test02(){
        //1.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.通过Spring容器获取bean
        Person p = (Person) context.getBean("person");
        p.eat();
        p.say();
        //3.关闭Spring容器
        ((ClassPathXmlApplicationContext)context).close();
    }

    /**
     * 传统方式创建并管理bean
     */
    @Test
    public void test01(){
        Person p = new Person();
        p.eat();
        p.say();
        p = null;
    }
}
