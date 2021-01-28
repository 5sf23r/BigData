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

public class Test01 {
    private SqlSessionFactory factory = null;

    @Before
    public void before() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        factory = builder.build(in);
    }

    /**
     * 二级缓存演示
     *      二级缓存 默认关闭 需要手工开启
     *      在全局范围内 跨事务有效
     *      由于二级缓存 范围大 时间长 可能造成严重的数据不一致问题 慎用
     */
    @Test
    public void test02() {
        SqlSession session1 = factory.openSession();
        User user1 = session1.selectOne("cn.tedu.userMapper.selc01",3);
        System.out.println(user1);
        session1.commit();

        SqlSession session2 = factory.openSession();
        User user2 = session2.selectOne("cn.tedu.userMapper.selc01",3);
        System.out.println(user2);
        session2.commit();

        session1.close();
        session2.close();
    }

    /**
     * 一级缓存演示
     *      一级缓存默认开启 且 无法关闭
     *      一级缓存在一个事务内有效 跨事务无效
     *      在同一个事务内多次执行相同的sql只会在第一次执行时真正走库，之后将数据缓存，之后的其他相同查询得到的都是缓存的数据
     */
    @Test
    public void test01() {
        SqlSession sqlSession = factory.openSession();

        User user1 = sqlSession.selectOne("cn.tedu.userMapper.selc01",3);
        System.out.println(user1);
        User user2 = sqlSession.selectOne("cn.tedu.userMapper.selc01",3);
        System.out.println(user2);

        sqlSession.close();
    }
}
