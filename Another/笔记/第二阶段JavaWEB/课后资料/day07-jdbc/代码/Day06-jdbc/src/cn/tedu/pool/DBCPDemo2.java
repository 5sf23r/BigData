package cn.tedu.pool;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * DBCP���ӳص�ʹ��
 * @author Administrator
 *
 */
public class DBCPDemo2 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		//����DBCP��ȡ����
//		BasicDataSource source = new BasicDataSource();
		//���ø�������ȡ����Դ���� --- Ŀ�ģ���ȡ�����ļ��е�������Ϣ����������Ϣ�ʹ�����
		Properties prop = new Properties();
		prop.load(
			new FileInputStream(
			new File(
			DBCPDemo2.class.getClassLoader().getResource("dbcp.properties").getPath())));
		BasicDataSourceFactory factory = new BasicDataSourceFactory();
		DataSource source = factory.createDataSource(prop);
		try {
			conn = source.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from exam");
			while(rs.next()){
				int id = rs.getInt("id");
				int chinese = rs.getInt("chinese");
			System.out.println("id��"+id+">>>>chinese:"+chinese);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					rs = null;
				}
			}
			if(stat != null){
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					stat =null;
				}
			}
			if(conn != null){
				try {
					//�˴����ǹر����ӣ��ǹ黹���ӡ�
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					conn = null;
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
