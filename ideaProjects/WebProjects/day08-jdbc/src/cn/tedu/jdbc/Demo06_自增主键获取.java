package cn.tedu.jdbc;

import cn.tedu.utils.C3P0Util;

import java.sql.*;

public class Demo06_自增主键获取 {

    public static void main(String[] args) {
        Connection connection = C3P0Util.getConnection();
        PreparedStatement ps = null;
        String sql1 = "insert into user values(null ,?)";
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,"二师兄");
            ps.executeUpdate();
            //获取主键的方法
            rs = ps.getGeneratedKeys();
            rs.next();//移动一个指向第一个数据id
            int id = rs.getInt(1);
            System.out.println(id);
            //第二条sql
            String sql2 = "insert into userInfo values(?,?,?,?) ";
            ps = connection.prepareStatement(sql2);
            ps.setInt(1,id);
            ps.setString(2,"110@qq.com");
            ps.setString(3,"110");
            ps.setString(4,"家");
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
