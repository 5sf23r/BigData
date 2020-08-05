package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo2 {
	public static void main(String[] args) {
		Connection conn =null;
		Statement stat = null;
		ResultSet rs = null;
		//注册数据库驱动
		//1.引入的驱动对象使用的是mysql驱动包中具体的类型，这样代码就和包名绑死在一起，
		//如果需要更换数据库，则还需要修改代码中的包名。
		
		//2.用户手动注册一次数据库驱动，底层也注册一次数据库驱动，一共注册两次，
		//两次注册可能会出现不必要的风险，我们只需注册一次即可。
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from exam");
			while(rs.next()){
				//next()调用的时候会先将光标向下移动一行。
				//如果向下移动的一行有效则返回true
				//如果向下移动的一行无效则放回false。
				//利用返回值可以遍历整张表的数据
				int id = rs.getInt(1);
				String name = rs.getString("name");
				System.out.println("id："+id+">>>>name:"+name);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					rs = null;
				}
			}
			if(stat != null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					stat =null;
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					conn = null;
				}
			}
			
			
		}
//		DriverManager.registerDriver(new Driver());
		//获取数据库连接
		
//		DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?user=root&password=root");
		//创建传输器
		
		//	传输sql并返回结果
		
		//遍历结果
		
		//关闭资源
		//后创建的先关闭
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
