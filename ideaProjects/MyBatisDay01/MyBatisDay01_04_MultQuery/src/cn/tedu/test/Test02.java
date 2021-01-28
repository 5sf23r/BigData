package cn.tedu.test;

import cn.tedu.domain.Grade;
import cn.tedu.domain.Room;
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

public class Test02 {
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;

    @Before
    public void before(){
        try {
            InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @After
    public void after(){
        sqlSession.close();
    }

    /**
        一对一:以Room为视角
     */
    @Test
    public void test02(){
        List<Room> list = sqlSession.selectList("cn.tedu.o2oMapper.o2o02");
        System.out.println(list);
    }

    /**
        一对一:以Grade为视角
     */
    @Test
    public void test01(){
        List<Grade> list = sqlSession.selectList("cn.tedu.o2oMapper.o2o01");
        System.out.println(list);
    }
}
