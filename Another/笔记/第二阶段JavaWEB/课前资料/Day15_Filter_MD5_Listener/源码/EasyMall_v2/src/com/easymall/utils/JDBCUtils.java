package com.easymall.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ������
 * ����c3p0���ӳش�������
 * @author admin
 *
 */
public class JDBCUtils {
	private JDBCUtils(){
		
	}
	private static ComboPooledDataSource pool = new ComboPooledDataSource();
	
	/**
	 * �������ӳض���
	 * ��ʱ����Ҫ�������ӳض����ȡ�µ�������Ϣ������ͨ��������������
	 * @return ����Դ����
	 */
	public static ComboPooledDataSource getObject(){
		return pool; 
	}
	/**
	 * ��ȡ����
	 * @return ���ݿ����Ӷ���
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
