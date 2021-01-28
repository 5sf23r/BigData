package cn.tedu.test;

import cn.tedu.domain.User;
import cn.tedu.domain.User2;
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
        sqlSession.close();
    }

    /**
     * 手动映射结果集
     *      当查询的表的列名和bean的属性名不一致时，将无法自动封装数据
     *      此时可以通过<resultMap>标签手动映射结果集
     */
    @Test
    public void test01(){
        List<User2> list = sqlSession.selectList("cn.tedu.userMapper.selc01");
        System.out.println(list);
    }

}
