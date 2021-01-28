package cn.tedu.test;

import cn.tedu.domain.Dept;
import cn.tedu.domain.Emp;
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

public class Test03 {
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
     * 1对多：以dept为视角
     */
    @Test
    public void test02(){
        List<Dept> list= sqlSession.selectList("cn.tedu.o2mMapper.o2m02");
        System.out.println(list);
    }

    /**
     * 1对多：以emp为视角
     */
    @Test
    public void test01(){
        List<Emp> list= sqlSession.selectList("cn.tedu.o2mMapper.o2m01");
        System.out.println(list);
    }
}
