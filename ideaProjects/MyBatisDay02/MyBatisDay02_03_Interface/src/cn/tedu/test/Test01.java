package cn.tedu.test;

import cn.tedu.domain.User;
import cn.tedu.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test01 {

    @Test
    public void test02() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("sqlMapConfig.xml"));
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        List<User> list = userMapper.selectBetweenAge(20,30);
        System.out.println(list);

        List<User> list2 = userMapper.selectOrderByAge();
        System.out.println(list2);

        session.close();
    }

    @Test
    public void test01() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("sqlMapConfig.xml"));
        SqlSession session = factory.openSession();

        Map<String,Integer> map = new HashMap<>();
        map.put("min",20);
        map.put("max",30);
        List<User> list = session.selectList("cn.tedu.mapper.UserMapper.selectBetweenAge", map);
        System.out.println(list);

        session.close();
    }
}
