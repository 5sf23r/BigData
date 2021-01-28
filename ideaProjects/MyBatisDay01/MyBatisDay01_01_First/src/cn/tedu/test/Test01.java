package cn.tedu.test;

import cn.tedu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {
    @Test
    public void test01() throws Exception {
        //1.创建SqlSession工厂
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //2.创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.通过名称空间+id调用sql
        List<User> list = sqlSession.selectList("cn.tedu.userMapper.slec01");
        //4.处理结果
        System.out.println(list);
        //5.关闭资源
        sqlSession.close();
    }
}
