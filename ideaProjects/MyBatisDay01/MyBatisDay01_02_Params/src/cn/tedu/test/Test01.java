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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;
    @Before
    public void before(){
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("sqlMapConfig.xml");
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

    /**
     * #{} 和 ${}的区别
     */
    @Test
    public void test05(){
        Map<String,String> map = new HashMap<>();
        map.put("c","age");
        List<User> list = sqlSession.selectList("cn.tedu.userMapper.selc04", map);
        System.out.println(list);
    }

    /**
     * #{} 和 ${}的区别
     */
    @Test
    public void test04(){
        Map<String,String> map = new HashMap<>();
        map.put("name","bbb");
        User user = sqlSession.selectOne("cn.tedu.userMapper.selc03", map);
        System.out.println(user);
    }

    /**
     * MyBatis值传递 - 单值传递
     */
    @Test
    public void test03(){
        User user = sqlSession.selectOne("cn.tedu.userMapper.selc02", "bbb");
        System.out.println(user);
    }

    /**
     * MyBatis值传递 - 对象传递
     */
    @Test
    public void test02(){
        User user = new User(0,"zzz",99);
        sqlSession.insert("cn.tedu.userMapper.insert01",user);
        sqlSession.commit();
    }

    /**
     * MyBatis值传递 - Map传递
     */
    @Test
    public void test01() throws Exception {
        //3.调用Sql
        Map<String,Integer> map = new HashMap<>();
        map.put("uid",5);
        User user = sqlSession.selectOne("cn.tedu.userMapper.slec01",map);
        //4.处理结果
        System.out.println(user);
    }
}
