package cn.tedu.trans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//JDBC实现事务的使用
public class TransDemo1 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//1.注册数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.创建连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day17", "root", "root");
			//关闭自动提交，开始事务
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement("update user set money =money -100 where name = ?");
			ps.setString(1, "a");
			ps.executeUpdate();
			
			int i=1/0;
			
			ps = conn.prepareStatement("update user set money =money +100 where name = ?");
			ps.setString(1, "b");
			ps.executeUpdate();
			conn.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			if(conn != null){
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
