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

/**
 * 创建连接和关闭资源的工具类
 * 工具类中一般是通过类名.方法的形式来调用其中的方法的。
 * @author Administrator
 *
 */
public class JDBCUtils {
	private JDBCUtils(){
		
	}
	private static Properties prop = null;
	//JDBCUtils.class.getClassLoader().getResource("conf.properties").getPath())
	//在类加载器启动的时候，可以读取当前类所在的工程的src目录，通过getClassLoader()方法获取类加载器，
	//再使用getResource()获取src目录，在参数位置书写要获取的文件名称。
	//最后通过getPath()获取String类型的路径返回值。
	static{
		//由于配置文件只需要读取一次即可，所以讲读取配置文件的过程书写在一个静态代码块中
		//这样在类加载的时候就会读取一个配置信息，并且保留在内存中，可以避免重复读取。
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(JDBCUtils.class.getClassLoader().getResource("conf.properties").getPath())));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 创建连接
	 * @throws Exception 
	 */
	public static Connection getConnection() throws Exception{
		
		Class.forName(prop.getProperty("driver"));
		return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
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
