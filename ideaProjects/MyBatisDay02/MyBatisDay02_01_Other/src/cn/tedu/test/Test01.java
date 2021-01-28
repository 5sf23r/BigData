package cn.tedu.test;

import cn.tedu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {

    private SqlSessionFactory factory = null;
    private SqlSession sqlSession = null;

    @Before
    public void before() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        factory = builder.build(in);
        sqlSession = factory.openSession();
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void test01(){
        List<User> list = sqlSession.selectList("cn.tedu.userMapper.selc01",3);
        System.out.println(list);
    }
}
