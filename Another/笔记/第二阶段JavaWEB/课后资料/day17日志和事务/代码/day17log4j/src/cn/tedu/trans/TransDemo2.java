package cn.tedu.trans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

//JDBC实现事务的使用
public class TransDemo2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Savepoint sp = null;
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
			
			ps = conn.prepareStatement("update user set money =money +100 where name = ?");
			ps.setString(1, "b");
			ps.executeUpdate();
			//保存点：保存点之前的操作全部成功，保存点之后的数据全部失败。
			sp = conn.setSavepoint();
			
			int i=1/0;
			
			ps = conn.prepareStatement("update user set money =money -100 where name = ?");
			ps.setString(1, "a");
			ps.executeUpdate();
			
			ps = conn.prepareStatement("update user set money =money +100 where name = ?");
			ps.setString(1, "b");
			ps.executeUpdate();
			
			
			
			
			
			conn.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			if(conn != null){
				if(sp != null){
					try {
						//如果sq不为null，则回滚到保存点
						conn.rollback(sp);
						//保存点之前的SQL需要被提交
						conn.commit();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
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
