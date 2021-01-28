package cn.tedu.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.*;

public class Test01 {
    /**
     * 回顾C3P0连接池
     */
    @Test
    public void test02(){
        DataSource dataSource = new ComboPooledDataSource();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.注册数据库驱动
            //2.获取数据库连接
            conn = dataSource.getConnection();
            //3.获取传输器对象
            ps = conn.prepareStatement("select * from user where id < ?");
            ps.setInt(1,3);
            //4.传输sql执行获取结果集
            rs = ps.executeQuery();
            //5.遍历结果集
            while(rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    rs = null;
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    ps = null;
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    conn = null;
                }
            }
        }
    }

    /**
     * 回顾jdbc
     */
    @Test
    public void test01(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.注册数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql:///ssmdb","root","Root*0201");
            //3.获取传输器对象
            ps = conn.prepareStatement("select * from user where id < ?");
            ps.setInt(1,3);
            //4.传输sql执行获取结果集
            rs = ps.executeQuery();
            //5.遍历结果集
            while(rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    rs = null;
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    ps = null;
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    conn = null;
                }
            }
        }
    }
}
