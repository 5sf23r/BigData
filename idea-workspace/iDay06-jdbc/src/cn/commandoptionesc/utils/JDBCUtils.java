package cn.commandoptionesc.utils;

import java.sql.*;

/**
 * 创建连接和关闭资源的工具类
 * 工具类中一般是通过类名.方法的形式来调用其中的方法的
 */
public class JDBCUtils {
    private JDBCUtils(){

    }
    /**
     * 创建连接
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/mydb1?useSSL=false&servertimezone=UTC&user=root");
    }
    /**
     * 关闭资源
     */
    public static void close(ResultSet rs, Statement stat, Connection conn){
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
        if(stat != null) {
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
