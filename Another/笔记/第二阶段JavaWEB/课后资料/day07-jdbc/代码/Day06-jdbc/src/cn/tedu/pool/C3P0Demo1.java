package cn.tedu.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * C3P0���ӳص�ʵ��
 * @author Administrator
 *
 */
public class C3P0Demo1 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		//����һ��c3p0����Դ�Ķ���
		ComboPooledDataSource source = new ComboPooledDataSource();
		//���ö����ȡ������Ϣ��
		/*try {
			source.setDriverClass("com.mysql.jdbc.Driver");
			source.setJdbcUrl("jdbc:mysql://localhost:3306/mydb1");
			source.setUser("root");
			source.setPassword("root");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}*/
		
		
		try {
			conn = source.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from exam");
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println("id��"+id+">>>>name:"+name);
			}
		} catch (SQLException e) {
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
