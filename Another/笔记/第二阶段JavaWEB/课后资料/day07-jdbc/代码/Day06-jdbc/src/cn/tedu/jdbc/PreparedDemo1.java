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
			//发送sql语句的主干部分
			ps = conn.prepareStatement("select * from user where name=?");
			//发送参数
			//setString(第几个问号的下标,对应下标的传入值);
			ps.setString(1,"ls");
			//此句表示sql语句的主干和参数部分都已经传递完成，继续执行当前sql语句。
			rs = ps.executeQuery();
			while(rs.next()){
				String password = rs.getString("password");
				System.out.println("password:"+password);
			}
			/*if(rs.next()){
				System.out.println("查询到结果");
			}else{
				System.out.println("查询不到结果");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
