package cn.tedu.dao;

import cn.tedu.pojo.User;
import cn.tedu.utils.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
* DAO层：数据访问层
* 1.专门用于数据库的访问和操作
* */
public class UserDao {

    /* 查询数据库中是否存在该用户
    * 参数：username是页面中传过来的 注册信息
    * 返回值类型：boolean类型
    * */
    public boolean findByUsername(String username) {
        boolean flag = true;
        Connection connection = C3P0Util.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user where username=? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if (rs.next()) {//如果username已经被注册了
                flag = true;
            } else {
                flag = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Util.close(rs,ps,connection);
        }
        return flag;
    }

    /*
    *  用户的注册时，数据插入的方法
    *  参数：User对象，为了程序的可扩展性
    *       原因：user对象中属性  对应着  user表的字段
    *             如果user表发生了改变，或者 需要注册信息发生了改变
    *             该方法中user对象不需要修改，参数就是user
    * */
    public void insertUserInfo (User user) {
        Connection connection = C3P0Util.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into user values(null,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getNickname());
            ps.setString(4,user.getEmail());
            int rows = ps.executeUpdate();
            System.out.println("受影响的行数："+rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Util.close(null,ps,connection);
        }
    }

}
