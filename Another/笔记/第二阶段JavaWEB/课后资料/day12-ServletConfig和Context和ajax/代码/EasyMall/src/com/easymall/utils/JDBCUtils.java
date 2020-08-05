package com.easymall.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ��ȡ���Ӻ͹ر���Դ
 * @author Administrator
 *
 */
public class JDBCUtils {
	private JDBCUtils(){
		
	}
	private static ComboPooledDataSource source = new ComboPooledDataSource();
	//��ȡ����
	public static Connection getConnection() throws SQLException{
			return source.getConnection();
	}
	//�ر���Դ
	public static void close(Connection conn,Statement stat,ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		if(stat != null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				stat =null;
			}
		}
		
		if(conn != null){
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
