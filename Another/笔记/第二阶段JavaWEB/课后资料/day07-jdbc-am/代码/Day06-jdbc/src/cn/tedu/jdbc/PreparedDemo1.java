package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.tedu.utils.JDBCUtils;

public class PreparedDemo1 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			//����sql�������ɲ���
			ps = conn.prepareStatement("select * from user where name=?");
			//���Ͳ���
			//setString(�ڼ����ʺŵ��±�,��Ӧ�±�Ĵ���ֵ);
			ps.setString(1,"ls");
			//�˾��ʾsql�������ɺͲ������ֶ��Ѿ�������ɣ�����ִ�е�ǰsql��䡣
			rs = ps.executeQuery();
			while(rs.next()){
				String password = rs.getString("password");
				System.out.println("password:"+password);
			}
			/*if(rs.next()){
				System.out.println("��ѯ�����");
			}else{
				System.out.println("��ѯ�������");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
