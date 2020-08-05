package cn.tedu.trans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

//JDBCʵ�������ʹ��
public class TransDemo2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Savepoint sp = null;
		try {
			//1.ע�����ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			//2.��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day17", "root", "root");
			//�ر��Զ��ύ����ʼ����
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement("update user set money =money -100 where name = ?");
			ps.setString(1, "a");
			ps.executeUpdate();
			
			ps = conn.prepareStatement("update user set money =money +100 where name = ?");
			ps.setString(1, "b");
			ps.executeUpdate();
			//����㣺�����֮ǰ�Ĳ���ȫ���ɹ��������֮�������ȫ��ʧ�ܡ�
			sp = conn.setSavepoint();
			
			int i=1/0;
			
			ps = conn.prepareStatement("update user set money =money -100 where name = ?");
			ps.setString(1, "a");
			ps.executeUpdate();
			
			ps = conn.prepareStatement("update user set money =money +100 where name = ?");
			ps.setString(1, "b");
			ps.executeUpdate();
			
			
			
			
			
			conn.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			if(conn != null){
				if(sp != null){
					try {
						//���sq��Ϊnull����ع��������
						conn.rollback(sp);
						//�����֮ǰ��SQL��Ҫ���ύ
						conn.commit();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
			
			
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
