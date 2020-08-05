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
	 * ��ȡ���ӳ�ʵ��
	 * @return pool
	 */
	public static DataSource getPool(){
		return pool;
	}
	
	/**
	 * �����ӳ��л�ȡһ������
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConn() throws SQLException{
		return pool.getConnection();
	}
	
	/**
	 * �ر���Դ
	 * @param conn ���ݿ�����
	 * @param stat ������
	 * @param rs �����
	 */
	public static void close(Connection conn, Statement stat, ResultSet rs){
		if(rs != null ){
			try {
				rs.close();//�ر�rs
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		if(stat != null ){
			try {
				stat.close();//�ر�stat
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				stat = null;
			}
		}
		if(conn != null ){
			try {
				conn.close();//�ر�conn
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}
		}
	}
}
