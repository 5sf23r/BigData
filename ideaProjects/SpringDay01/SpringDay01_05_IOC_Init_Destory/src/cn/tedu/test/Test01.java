package cn.tedu.test;

import cn.tedu.domain.JDBCUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    /**
     * 初始化 销毁 方法
     *  <bean id="jdbcUtils" class="cn.tedu.domain.JDBCUtils"
     *  init-method="initConn" destroy-method="destoryConn"
     *  ></bean>
     */
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCUtils jdbcUtils = (JDBCUtils) context.getBean("jdbcUtils");
        jdbcUtils.insert();
        jdbcUtils.update();
        ((ClassPathXmlApplicationContext)context).close();
    }

    @Test
    public void test01(){
        JDBCUtils jdbcUtils = new JDBCUtils();
        jdbcUtils.initConn();
        jdbcUtils.insert();
        jdbcUtils.update();
        jdbcUtils.destoryConn();
        jdbcUtils = null;
    }
}
