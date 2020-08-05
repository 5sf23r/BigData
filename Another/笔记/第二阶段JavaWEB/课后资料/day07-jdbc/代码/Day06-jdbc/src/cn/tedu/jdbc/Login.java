package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import cn.tedu.utils.JDBCUtils;

/**
 * 登录功能 ---JDBC实现
 * @author Administrator
 *
 */
public class Login {
	public static void main(String[] args) {
		//要求用户输入用户名和密码
		Scanner sc = new Scanner(System.in);
		System.out.println("请求输入用户名：");
		String name = sc.nextLine();
		System.out.println("请输入密码：");
		String password = sc.nextLine();
//		loginTest(name,password);
		loginTestPrepared(name,password);
	}
	//prepared实现JDBC
	private static void loginTestPrepared(String name, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement("select * from user "
					+ "where name = ? and password = ?");
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("登录成功");
			}else{
				System.out.println("登录失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}

	private static void loginTest(String name, String password) {
		//将获取到的值和数据库中的数据作比对
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from user where name='"+name+"' and password='"+password+"'");
			if(rs.next()){
				System.out.println("登录成功");
			}else{
				System.out.println("登录失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}
		
	}

	
	
	
	
	
	
	
	
	
}
