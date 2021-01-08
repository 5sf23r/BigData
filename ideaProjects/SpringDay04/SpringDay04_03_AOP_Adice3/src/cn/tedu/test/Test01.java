package cn.tedu.test;

import cn.tedu.web.UserServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 多个切面执行顺序
 *      配置多个切面按照配置顺序依次生效
 *      多个切面之间的调用过程非常类似于方法调用过程 一层一层钻入 一层一层钻出 依次执行
 */
public class Test01 {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServlet userServlet = (UserServlet) context.getBean("userServlet");
        //userServlet.addUser();
        userServlet.queryUser();
        ((ClassPathXmlApplicationContext)context).close();
    }
}
