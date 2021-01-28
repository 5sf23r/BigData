package cn.tedu.test;

import cn.tedu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {
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
        //5.关闭资源
        sqlSession.close();
    }

    @Test
    public void delete2(){
        List<Integer> list = Arrays.asList(11,12,5,3);
        sqlSession.delete("cn.tedu.userMapper.delete02",list);
        sqlSession.commit();
    }
    @Test
    public void delete(){
        //User user = new User(9,"qqq",88);
        //User user = new User(0,null,99);
        User user = new User(0,"eee",33);
        sqlSession.delete("cn.tedu.userMapper.delete01",user);
        sqlSession.commit();
    }

    @Test
    public void insert(){
        //User user = new User(0,"qqq",888);
        //User user = new User(0,null,99);
        //User user = new User(0,"yyy",0);
        User user = new User(0,null,0);
        sqlSession.insert("cn.tedu.userMapper.insert01",user);
        sqlSession.commit();
    }

    @Test
    public void select(){
        //User user = new User(2,"bbb",29);
        // User user = new User(2,null,0);
        //User user = new User(2,"bbb",0);
        User user = new User(0,"bbb",29);
        List<User> list = sqlSession.selectList("cn.tedu.userMapper.select01", user);
        System.out.println(list);
    }

    @Test
    public void update(){
        //User user = new User(3,"cccc",49);
        //User user = new User(3,null,49);
        User user = new User(3,"ccc",0);
        sqlSession.update("cn.tedu.userMapper.update01",user);
        sqlSession.commit();
    }
}
