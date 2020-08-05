package com.easymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.easymall.domain.User;
import com.easymall.utils.JDBCUtils;

public class UserDao {

	/**
	 * �����û�����ѯ�û�
	 * @param username Ҫ���ҵ��û���
	 * @return �ҵ����û�bean ���û�ҵ�����null
	 */
	public User findUserByUserName(String username) {
		//1.ע�����ݿ����� - �����ӳأ����Բ���
		Connection conn = null;;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2.��ȡ���ݿ����� - ͨ�����ӳػ�ȡ
			conn = JDBCUtils.getConnection();
			//3.��ȡ������
			ps = conn.prepareStatement("select * from user where username = ?");
			ps.setString(1,username);
			//4.����sqlִ��
			rs = ps.executeQuery();
			//5.��ȡ���
			if(rs.next()){
				//�鵽����Ϣ
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setEmail(rs.getString("email"));
				return user;
			}else{
				//û�鵽
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//6.�ر������� - ��conn�������ӳ�
			JDBCUtils.close(conn, ps, null);
		}
	}

	/**
	 * �����ݿ���User������һ��User��Ϣ
	 * @param user ��װ���û���Ϣ��bean
	 * @throws SQLException 
	 */
	public void addUser(User user) {
		//1.ע�����ݿ����� - �����ӳأ����Բ���
		Connection conn = null;;
		PreparedStatement ps = null;
		try {
			//2.��ȡ���ݿ����� - ͨ�����ӳػ�ȡ
			conn = JDBCUtils.getConnection();
			//3.��ȡ������
			ps = conn.prepareStatement("insert into user values (null,?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNickname());
			ps.setString(4,user.getEmail());
			//4.����sqlִ��
			ps.executeUpdate();
			//5.��ȡ���
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//6.�ر������� - ��conn�������ӳ�
			JDBCUtils.close(conn, ps, null);
		}
	}

	/**
	 * �����û�����������û�
	 * @param username Ҫ���ҵ��û���
	 * @param password Ҫ���ҵ�����
	 * @return
	 */
	public User findUserByUserNameAndPsw(String username, String password) {
		//1.ע�����ݿ����� - �����ӳأ����Բ���
		Connection conn = null;;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2.��ȡ���ݿ����� - ͨ�����ӳػ�ȡ
			conn = JDBCUtils.getConnection();
			//3.��ȡ������
			ps = conn.prepareStatement("select * from user where username = ? and password = ?");
			ps.setString(1,username);
			ps.setString(2, password);
			//4.����sqlִ��
			rs = ps.executeQuery();
			//5.��ȡ���
			if(rs.next()){
				//�鵽����Ϣ
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setEmail(rs.getString("email"));
				return user;
			}else{
				//û�鵽
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//6.�ر������� - ��conn�������ӳ�
			JDBCUtils.close(conn, ps, null);
		}
	}
}
