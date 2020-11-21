package cn.commandoptionesc.pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class C3P0Demo1 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        //创建一个C3P0数据源的对象
        ComboPooledDataSource source = new ComboPooledDataSource();
        //利用对象读取配置信息
        try {
            source.setDriverClass("com.mysql.cj.jdbc.Driver");
            source.setJdbcUrl("jdbc:mysql://localhost:3306/mydb1?useSSL=false&servertimezone=UTC");
            source.setUser("root");
            source.setPassword(null);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        try {
            conn = source.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from exam");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id:"+id+">>>>name:"+name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    rs = null;
                }
            }
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
                    //此处不是关闭连接，是归还连接
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
