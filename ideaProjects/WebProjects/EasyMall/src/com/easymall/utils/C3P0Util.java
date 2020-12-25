package com.easymall.utils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class C3P0Util {
    public static void main(String[] args) {
        Connection connection = C3P0Util.getConnection();
        System.out.println(connection);
    }
    /**
     * 1.定义成员变量
     */
    private static DataSource ds;

    /**
     * 2.读取配置文件
     */
    static{
        ds = new ComboPooledDataSource();
    }

    /**
     * 3.获得连接
     */
    public static Connection getConnection()  {
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 4.释放连接
     */
    public static void close(PreparedStatement ps, Connection conn){
        close(null,ps,conn);

    }
    public static void close(ResultSet rs, Statement ps, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
