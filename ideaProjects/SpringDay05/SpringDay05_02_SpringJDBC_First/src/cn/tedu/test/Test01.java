package cn.tedu.test;

import cn.tedu.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * JdbcTemplate完成CRUD
 */
public class Test01 {
    private ApplicationContext context = null;
    private JdbcTemplate jdbcTemplate = null;

    //下面@Test执行之前都会调用@Before
    @Before
    public void beofre(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }
    //下面@Test执行之后都会调用@After
    @After
    public void after(){
        ((ClassPathXmlApplicationContext)context).close();
    }

    /**
     * 自定义RowMapper
     */
    class UserRowMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            return user;
        }
    }

    /**
     * 查询为一个对象集合 - 通过BeanPropertyRowMapper自动实现映射
     */
    @Test
    public void test10(){
        List<User> list = jdbcTemplate.query(
                "select * from user where id < ?",
                new BeanPropertyRowMapper<User>(User.class),
                3);
        System.out.println(list);
    }

    /**
     * 查询为一个对象 - 通过BeanPropertyRowMapper自动实现映射
     */
    @Test
    public void test9(){
        User user = jdbcTemplate.queryForObject(
                "select * from user where id = ?",
                new BeanPropertyRowMapper<User>(User.class),
                3);
        System.out.println(user);
    }

    /**
     * 查询为一个对象集合 - 通过自定义RowMapper实现映射
     */
    @Test
    public void test08(){
        List<User> list = jdbcTemplate.query("select * from user where id < ?", new UserRowMapper(), 3);
        System.out.println(list);
    }


    /**
     * 查询为一个对象 - 通过自定义RowMapper实现映射
     */
    @Test
    public void test07(){
        User user = jdbcTemplate.queryForObject("select * from user where id = ?", new UserRowMapper(), 3);
        System.out.println(user);
    }

    /**
     * 查询为一个SqlRowSet
     */
    @Test
    public void test06(){
        SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from user where id < ?", 3);
        while(rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            System.out.println(user);
        }
    }

    /**
     * 查询为一个List<Map>
     */
    @Test
    public void test05(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user where id < ?", 3);
        System.out.println(list);
    }

    /**
     * 查询为一个Map
     */
    @Test
    public void test04(){
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from user where id = ?", 3);
        System.out.println(map);
    }

    /**
     * 删除
     */
    @Test
    public void test03(){
        jdbcTemplate.update("delete from user where id = ?",15);
    }

    /**
     * 修改
     */
    @Test
    public void test02(){
        jdbcTemplate.update("update user set age = ? where id = ?",88,15);
    }

    /**
     * 新增
     */
    @Test
    public void test01(){
        jdbcTemplate.update("insert into user values (null,?,?)","zzz",99);
    }
}
