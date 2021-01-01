package cn.tedu.test;

import cn.tedu.domain.Cart;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    /**
     * 单例
     *     容器初始化时创建对象，保存在Spring内部的Map中
     *     之后获取对象直接返回Map内保存的对象，每次获取到的都是同一个对象
     *     直到Spring容器销毁时保存在Map中的对象跟着被销毁
     * 多例
     *     容器初始化时不创建对象
     *     每次获取对象都重新创建并返回对象，这些对象也不会保存到Map中
     *     这些对象什么时候销毁取决于程序，不会再Spring容器销毁时跟着销毁
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Cart cart1 = (Cart) context.getBean("cart");
        System.out.println(cart1);
        Cart cart2 = (Cart) context.getBean("cart");
        System.out.println(cart2);
        ((ClassPathXmlApplicationContext)context).close();
    }
}
