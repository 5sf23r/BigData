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
 * �������Ӻ͹ر���Դ�Ĺ�����
 * ��������һ����ͨ������.��������ʽ���������еķ����ġ�
 * @author Administrator
 *
 */
public class JDBCUtils {
	private JDBCUtils(){
		
	}
	private static Properties prop = null;
	//JDBCUtils.class.getClassLoader().getResource("conf.properties").getPath())
	//���������������ʱ�򣬿��Զ�ȡ��ǰ�����ڵĹ��̵�srcĿ¼��ͨ��getClassLoader()������ȡ���������
	//��ʹ��getResource()��ȡsrcĿ¼���ڲ���λ����дҪ��ȡ���ļ����ơ�
	//���ͨ��getPath()��ȡString���͵�·������ֵ��
	static{
		//���������ļ�ֻ��Ҫ��ȡһ�μ��ɣ����Խ���ȡ�����ļ��Ĺ�����д��һ����̬�������
		//����������ص�ʱ��ͻ��ȡһ��������Ϣ�����ұ������ڴ��У����Ա����ظ���ȡ��
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
	 * ��������
	 * @throws Exception 
	 */
	public static Connection getConnection() throws Exception{
		
		Class.forName(prop.getProperty("driver"));
		return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
	}
	/**
	 * �ر���Դ
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
