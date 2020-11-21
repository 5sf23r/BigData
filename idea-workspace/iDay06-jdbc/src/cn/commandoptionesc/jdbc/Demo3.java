package cn.commandoptionesc.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

/**
 * 向数据路mydb1.exam表插入和更新数据
 */
public class Demo3 {
    @Test
    public void add(){
        Connection conn = null;
        Statement stat = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mydb1?useSSL=false&servertimezone=UTC&user=root");
            stat = conn.createStatement();
            int count = stat.executeUpdate("insert into exam values(null,'鸣人',10,20,30)");
            if(count >0){
                System.out.println("恭喜插入成功，受到影响的行数为："+count);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    stat = null;
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    conn = null;
                }
            }
        }
    }
    @Test
    public void update(){
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mydb1?useSSL=false&servertimezone=UTC&user=root");
            stat = conn.createStatement();
            int count = stat.executeUpdate("update exam set chinese = 90 where id = 2");
            if(count >0){
                System.out.println("更新成功，受到影响的行数为："+count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    stat = null;
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    conn = null;
                }
            }
        }
    }
}
