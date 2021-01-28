package cn.tedu.dao;

import cn.tedu.domain.User;
import cn.tedu.utils.C3P0Util;
import cn.tedu.utils.TransactionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
    create database ssmdb;
    use ssmdb;
    create table user(id int primary key auto_increment,name varchar(20),age int);
    insert into user values (null,'aaa',19);
    insert into user values (null,'bbb',26);
    insert into user values (null,'ccc',22);
 */

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void addUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = TransactionManager.getConn();
            ps = conn.prepareStatement("insert into user values (null,?,?)");
            ps.setString(1, user.getName());
            ps.setInt(2,user.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            C3P0Util.close(rs,ps,null);
        }
    }

    @Override
    public User queryUser(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = C3P0Util.getConnection();
            ps = conn.prepareStatement("select * from user where id = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return user;
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            C3P0Util.close(rs,ps,conn);
        }
    }
}
