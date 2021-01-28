package cn.tedu.test;

import cn.tedu.domain.Prod;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test02 {
    private ApplicationContext context = null;
    private JdbcTemplate jdbcTemplate = null;

    @Before
    public void beofre(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }

    @After
    public void after(){
        ((ClassPathXmlApplicationContext)context).close();
    }

    @Test
    public void test02(){
        Prod prod = jdbcTemplate.queryForObject("select * from prod where id = ?",
                new BeanPropertyRowMapper<Prod>(Prod.class),
                2);
        System.out.println(prod);
    }

    @Test
    public void test01(){
        Prod prod = jdbcTemplate.queryForObject(
                "select * from prod where id = ?",
                new RowMapper<Prod>() {
                    @Override
                    public Prod mapRow(ResultSet rs, int i) throws SQLException {
                        Prod  prod = new Prod();
                        prod.setId(rs.getInt("id"));
                        prod.setName(rs.getString("name"));
                        prod.setPrice(rs.getDouble("price"));
                        return prod;
                    }
                },
                2);
        System.out.println(prod);
    }
}
