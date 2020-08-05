package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.tedu.utils.JDBCUtils;

/**
 * 向数据库mydb1.exam表插入和更新数据
 * @author Administrator
 *
 */
public class Demo3 {
	@Test
	public void add(){
		Connection conn = null;
		Statement stat = null;
		try {
			conn = JDBCUtils.getConnection();
			stat = conn.createStatement();
			//count为执行成功之后受到影响的行数
			int count = stat.executeUpdate("insert into exam values(null,'鸣人',10,20,30)");
			if(count >0){
				System.out.println("恭喜插入成功，受到影响的行数为："+count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, stat, conn);
			
		}
	}
	
	@Test
	public void update(){
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///mydb1", "root", "root");
			stat = conn.createStatement();
			int count = stat.executeUpdate("update exam set chinese = 90 where id = 2");
			if(count > 0){
				System.out.println("更新成功，受到影响的行数为："+count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(stat !=null){
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					stat = null;
				}
			}
			if(conn !=null){
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
	
	@Test
	public void delete(){
		Connection conn = null;
		Statement stat = null;
		try {
			conn = JDBCUtils.getConnection();
			stat = conn.createStatement();
			int count = stat.executeUpdate("delete from exam where id = 4");
			if(count>0){
				System.out.println("删除成功，受到影响的行数为："+count);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, stat, conn);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
