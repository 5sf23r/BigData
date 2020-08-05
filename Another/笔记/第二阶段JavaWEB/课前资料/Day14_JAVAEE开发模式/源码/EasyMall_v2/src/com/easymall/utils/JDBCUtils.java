package com.easymall.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 工具类
 * 利用c3p0连接池创建连接
 * @author admin
 *
 */
public class JDBCUtils {
	private JDBCUtils(){
		
	}
	private static ComboPooledDataSource pool = new ComboPooledDataSource();
	
	/**
	 * 创建连接池对象
	 * 有时会需要利用连接池对象读取新的配置信息，可以通过本方法来操作
	 * @return 数据源对象
	 */
	public static ComboPooledDataSource getObject(){
		return pool; 
	}
	/**
	 * 获取连接
	 * @return 数据库连接对象
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return pool.getConnection();
	}

	public static void close(Connection conn,Statement stat,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally{
				rs = null;
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally{
				stat = null;
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally{
				conn = null;
			}
		}
	}
}
