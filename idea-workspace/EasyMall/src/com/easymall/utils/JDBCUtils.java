package com.easymall.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.*;
/**
 * 获取连接和关闭资源
 */
public class JDBCUtils {
    private JDBCUtils(){

    }
    private static ComboPooledDataSource source = new ComboPooledDataSource();
    //获取连接
    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }
    //关闭资源
    //连接写死，检测是否可以成功获取连接
    /*
    public static Connection getConnection() throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/easymall?useSSL=false&servertimezone=UTC&allowPublicKeyRetrieval=true&user=root&password=Root*0201");
    }
     */
    public static void close(Connection conn, Statement stat, ResultSet rs){
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
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                conn = null;
            }
        }
    }
}
