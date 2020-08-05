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
		//ע�����ݿ�����
		//1.�������������ʹ�õ���mysql�������о�������ͣ���������ͺͰ���������һ��
		//�����Ҫ�������ݿ⣬����Ҫ�޸Ĵ����еİ�����
		
		//2.�û��ֶ�ע��һ�����ݿ��������ײ�Ҳע��һ�����ݿ�������һ��ע�����Σ�
		//����ע����ܻ���ֲ���Ҫ�ķ��գ�����ֻ��ע��һ�μ��ɡ�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from exam");
			while(rs.next()){
				//next()���õ�ʱ����Ƚ���������ƶ�һ�С�
				//��������ƶ���һ����Ч�򷵻�true
				//��������ƶ���һ����Ч��Ż�false��
				//���÷���ֵ���Ա������ű������
				int id = rs.getInt(1);
				String name = rs.getString("name");
				System.out.println("id��"+id+">>>>name:"+name);
				
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
		//��ȡ���ݿ�����
		
//		DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?user=root&password=root");
		//����������
		
		//	����sql�����ؽ��
		
		//�������
		
		//�ر���Դ
		//�󴴽����ȹر�
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
