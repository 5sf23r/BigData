package cn.tedu.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

import cn.tedu.utils.JDBCUtils;

/**
 * DBCP���ӳص�ʹ��
 * @author Administrator
 *
 */
public class DBCPDemo1 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		//����DBCP��ȡ����
		BasicDataSource source = new BasicDataSource();
		//�ֶ�����������Ϣ
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/mydb1");
		source.setUsername("root");
		source.setPassword("root");
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
