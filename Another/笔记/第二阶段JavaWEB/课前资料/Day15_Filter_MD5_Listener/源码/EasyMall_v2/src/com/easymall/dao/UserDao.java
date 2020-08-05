package com.easymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.easymall.domain.User;
import com.easymall.utils.JDBCUtils;

public class UserDao {

	/**
	 * 根据用户名查询用户
	 * @param username 要查找的用户名
	 * @return 找到的用户bean 如果没找到返回null
	 */
	public User findUserByUserName(String username) {
		//1.注册数据库驱动 - 有连接池，可以不用
		Connection conn = null;;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2.获取数据库连接 - 通过连接池获取
			conn = JDBCUtils.getConnection();
			//3.获取传输器
			ps = conn.prepareStatement("select * from user where username = ?");
			ps.setString(1,username);
			//4.传输sql执行
			rs = ps.executeQuery();
			//5.获取结果
			if(rs.next()){
				//查到了信息
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setEmail(rs.getString("email"));
				return user;
			}else{
				//没查到
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//6.关闭了连接 - 将conn还回连接池
			JDBCUtils.close(conn, ps, null);
		}
	}

	/**
	 * 向数据库中User表新增一条User信息
	 * @param user 封装了用户信息的bean
	 * @throws SQLException 
	 */
	public void addUser(User user) {
		//1.注册数据库驱动 - 有连接池，可以不用
		Connection conn = null;;
		PreparedStatement ps = null;
		try {
			//2.获取数据库连接 - 通过连接池获取
			conn = JDBCUtils.getConnection();
			//3.获取传输器
			ps = conn.prepareStatement("insert into user values (null,?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNickname());
			ps.setString(4,user.getEmail());
			//4.传输sql执行
			ps.executeUpdate();
			//5.获取结果
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//6.关闭了连接 - 将conn还回连接池
			JDBCUtils.close(conn, ps, null);
		}
	}

	/**
	 * 根据用户名密码查找用户
	 * @param username 要查找的用户名
	 * @param password 要查找的密码
	 * @return
	 */
	public User findUserByUserNameAndPsw(String username, String password) {
		//1.注册数据库驱动 - 有连接池，可以不用
		Connection conn = null;;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2.获取数据库连接 - 通过连接池获取
			conn = JDBCUtils.getConnection();
			//3.获取传输器
			ps = conn.prepareStatement("select * from user where username = ? and password = ?");
			ps.setString(1,username);
			ps.setString(2, password);
			//4.传输sql执行
			rs = ps.executeQuery();
			//5.获取结果
			if(rs.next()){
				//查到了信息
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setEmail(rs.getString("email"));
				return user;
			}else{
				//没查到
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//6.关闭了连接 - 将conn还回连接池
			JDBCUtils.close(conn, ps, null);
		}
	}
}
