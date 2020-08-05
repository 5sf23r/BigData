package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;




public class Demo1 {
	public static void main(String[] args) throws SQLException {
		//ע�����ݿ�����
		DriverManager.registerDriver(new Driver());
		//��ȡ���ݿ�����
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		//����������
		Statement stat = conn.createStatement();
		//	����sql�����ؽ��
		ResultSet rs = stat.executeQuery("select * from exam");
		//�������
		while(rs.next()){
			//next()���õ�ʱ����Ƚ���������ƶ�һ�С�
			//��������ƶ���һ����Ч�򷵻�true
			//��������ƶ���һ����Ч��Ż�false��
			//���÷���ֵ���Ա������ű������
			int id = rs.getInt(1);
			String name = rs.getString("name");
			System.out.println("id��"+id+">>>>name:"+name);
			
		}
		//�ر���Դ
		//�󴴽����ȹر�
		rs.close();
		stat.close();
		conn.close();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
