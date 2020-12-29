package com.mall.dao;

import com.mall.domain.User;
import com.mall.utils.C3P0Util;
import com.mall.utils.MD5Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    /**
     * 根据用户名查询用户是否存在
     * @param username  用户名称
     * @return 为true则存在用户名，  为false则不存在用户
     */
    public boolean findUserByUsername(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = C3P0Util.getConnection();
            ps = conn.prepareStatement("select * from user where username = ?");
            ps.setString(1,username);
            rs = ps.executeQuery();
            if(rs.next()){
                System.out.println(1);
                return true;
            }else{
                System.out.println(2);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            C3P0Util.close(rs,ps,conn);
        }

    }
    /**
     * 添加用户
     * @param user  用户信息对象
     */
    public void addUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = C3P0Util.getConnection();
            ps = conn.prepareStatement("insert into user values(null,?,?,?,?)");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getNickname());
            ps.setString(4,user.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            C3P0Util.close(null,ps,conn);
        }
    }

    public User findUserByUsernameAndPwd(String username,String password){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            connection = C3P0Util.getConnection();
            ps = connection.prepareStatement("select * from user where username=? and password=? ");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                //查询到用户信息，返回User对象
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            C3P0Util.close(rs,ps,connection);
        }
        return user;
    }
}
