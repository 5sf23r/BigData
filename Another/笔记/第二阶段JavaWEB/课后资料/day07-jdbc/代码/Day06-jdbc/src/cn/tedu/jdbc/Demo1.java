package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;




public class Demo1 {
	public static void main(String[] args) throws SQLException {
		//注册数据库驱动
		DriverManager.registerDriver(new Driver());
		//获取数据库连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		//创建传输器
		Statement stat = conn.createStatement();
		//	传输sql并返回结果
		ResultSet rs = stat.executeQuery("select * from exam");
		//遍历结果
		while(rs.next()){
			//next()调用的时候会先将光标向下移动一行。
			//如果向下移动的一行有效则返回true
			//如果向下移动的一行无效则放回false。
			//利用返回值可以遍历整张表的数据
			int id = rs.getInt(1);
			String name = rs.getString("name");
			System.out.println("id："+id+">>>>name:"+name);
			
		}
		//关闭资源
		//后创建的先关闭
		rs.close();
		stat.close();
		conn.close();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
