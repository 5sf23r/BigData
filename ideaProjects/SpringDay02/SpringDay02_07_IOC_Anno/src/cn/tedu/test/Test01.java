package cn.tedu.test;

import cn.tedu.domain.Cat;
import cn.tedu.domain.Dog;
import cn.tedu.domain.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p = (Person) context.getBean("person");
        System.out.println(p);
        Dog dog = (Dog) context.getBean("dog");
        System.out.println(dog);
        Cat cat = (Cat) context.getBean("cat");
        System.out.println(cat);
        ((ClassPathXmlApplicationContext)context).close();
    }
}
