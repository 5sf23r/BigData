package cn.tedu.test;

import cn.tedu.domain.PErson2;
import cn.tedu.domain.Person;
import cn.tedu.domain.pErson3;
import cn.tedu.domain.pErson4;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * SpringIOC 注解方式实现的id推断规则
 *      看类名的第二个字母
 *          如果第二个字母是小写，类名首字母转小写作为id
 *          如果第二个字母是大写，类名保持不变作为id
 *      也可以手动指定id,一旦手动指定id，则不再自动推断
 */
public class Test01 {
    @Test
    public void test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        pErson4 p = (pErson4) context.getBean("person4");
        System.out.println(p);
        ((ClassPathXmlApplicationContext)context).close();
    }

 @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        pErson3 p = (pErson3) context.getBean("pErson3");
        System.out.println(p);
        ((ClassPathXmlApplicationContext)context).close();
    }

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PErson2 p = (PErson2) context.getBean("PErson2");
        System.out.println(p);
        ((ClassPathXmlApplicationContext)context).close();
    }

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p = (Person) context.getBean("person");
        System.out.println(p);
        ((ClassPathXmlApplicationContext)context).close();
    }
}
