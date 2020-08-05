package cn.tedu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 创建连接和关闭资源的工具类
 * 工具类中一般是通过类名.方法的形式来调用其中的方法的。
 * @author Administrator
 *
 */
public class JDBCUtils {
	private JDBCUtils(){
		
	}
	/**
	 * 创建连接
	 * @throws Exception 
	 */
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql:"
				+ "//localhost:3306/mydb1?user=root&password=root");
	}
	/**
	 * 关闭资源
	 */
	public static void close(ResultSet rs,Statement stat,Connection conn){
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
	

}
