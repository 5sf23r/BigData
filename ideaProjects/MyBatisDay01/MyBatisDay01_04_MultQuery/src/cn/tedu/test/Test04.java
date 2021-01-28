package cn.tedu.test;

import cn.tedu.domain.Dept;
import cn.tedu.domain.Emp;
import cn.tedu.domain.Stu;
import cn.tedu.domain.Teacher;
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

public class Test04 {
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
     * 多对多：以Teacher为视角
     */
    @Test
    public void test02(){
        List<Teacher> list= sqlSession.selectList("cn.tedu.m2mMapper.m2m02");
        System.out.println(list);
    }

    /**
     * 多对多：以Stu为视角
     */
    @Test
    public void test01(){
        List<Stu> list= sqlSession.selectList("cn.tedu.m2mMapper.m2m01");
        System.out.println(list);
    }
}
