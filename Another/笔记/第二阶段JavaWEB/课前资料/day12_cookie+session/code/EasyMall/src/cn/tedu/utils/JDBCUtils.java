package cn.tedu.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	private static ComboPooledDataSource pool = new ComboPooledDataSource();
	
	private JDBCUtils(){}
	
	/**
	 * 获取连接池实例
	 * @return pool
	 */
	public static DataSource getPool(){
		return pool;
	}
	
	/**
	 * 从连接池中获取一个连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConn() throws SQLException{
		return pool.getConnection();
	}
	
	/**
	 * 关闭资源
	 * @param conn 数据库连接
	 * @param stat 传输器
	 * @param rs 结果集
	 */
	public static void close(Connection conn, Statement stat, ResultSet rs){
		if(rs != null ){
			try {
				rs.close();//关闭rs
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		if(stat != null ){
			try {
				stat.close();//关闭stat
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				stat = null;
			}
		}
		if(conn != null ){
			try {
				conn.close();//关闭conn
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}
		}
	}
}
