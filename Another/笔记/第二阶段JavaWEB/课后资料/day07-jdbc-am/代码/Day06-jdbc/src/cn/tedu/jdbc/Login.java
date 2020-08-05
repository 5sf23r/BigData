package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import cn.tedu.utils.JDBCUtils;

/**
 * ��¼���� ---JDBCʵ��
 * @author Administrator
 *
 */
public class Login {
	public static void main(String[] args) {
		//Ҫ���û������û���������
		Scanner sc = new Scanner(System.in);
		System.out.println("���������û�����");
		String name = sc.nextLine();
		System.out.println("���������룺");
		String password = sc.nextLine();
//		loginTest(name,password);
		loginTestPrepared(name,password);
	}
	//preparedʵ��JDBC
	private static void loginTestPrepared(String name, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement("select * from user "
					+ "where name = ? and password = ?");
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("��¼�ɹ�");
			}else{
				System.out.println("��¼ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}

	private static void loginTest(String name, String password) {
		//����ȡ����ֵ�����ݿ��е��������ȶ�
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from user where name='"+name+"' and password='"+password+"'");
			if(rs.next()){
				System.out.println("��¼�ɹ�");
			}else{
				System.out.println("��¼ʧ��");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}
		
	}

	
	
	
	
	
	
	
	
	
}
