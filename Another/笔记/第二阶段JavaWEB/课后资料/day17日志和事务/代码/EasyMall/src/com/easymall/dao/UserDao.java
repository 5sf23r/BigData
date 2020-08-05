package com.easymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.easymall.domain.User;
import com.easymall.utils.JDBCUtils;

public class UserDao {

	public User findUserByUsernameAndPassword(String username, String password) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stat = conn.prepareStatement("select * from user where username=? and password=?");
			stat.setString(1, username);
			stat.setString(2, password);
			rs = stat.executeQuery();
			if(rs.next()){
				//查询到用户信息，返回User对象
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setEmail(rs.getString("email"));
				return user;
			}else{
				//没有查询到用户信息
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(conn, stat, rs);
		}
		
		
	}
	/**
	 * 向user表中插入一条用户数据
	 * @param user 用户信息对象
	 */
	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = JDBCUtils.getConnection();
			stat = conn.prepareStatement("insert into user values(null,?,?,?,?)");
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getPassword());
			stat.setString(3, user.getNickname());
			stat.setString(4,user.getEmail());
			stat.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(conn, stat, null);
		}
		
	}
	/**
	 * 根据用户名查询用户信息
	 * @param username 用户名
	 */
	public User findUserByUsername(String username) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stat = conn.prepareStatement("select * from user where username=? ");
			stat.setString(1, username);
			rs = stat.executeQuery();
			if(rs.next()){
				//查询到用户信息，返回User对象
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setEmail(rs.getString("email"));
				return user;
			}else{
				//没有查询到用户信息
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(conn, stat, rs);
		}
	}

	
	
	
	
	
	
	
	
	
	
}
