package cn.tedu.test;

import cn.tedu.domain.Hero;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hero hero = (Hero) context.getBean("hero");
        System.out.println(hero);
        ((ClassPathXmlApplicationContext)context).close();
    }

}
