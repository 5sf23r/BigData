package cn.tedu.jdbc;

import cn.tedu.utils.C3P0Util;

import java.sql.*;

public class Demo02_预编译语句对象 {

    public static void main(String[] args) {
        //1.获取数据库连接
        Connection conn = C3P0Util.getConnection();
        //2.创建一个预编译语句对象
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement
                    ("select * from teacher where t_id=?");
            //把需要的值 赋值给 ?
            //参数一：是第几个问号?
            //参数二：问号?对应的值
            ps.setInt(1,1);
            //执行sql语句
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("t_name"));
            }

            //模拟一个sql注入的场景
            //证明了：预编译语句对象确实能防止sql注入
            String sql = "select * from teacher where t_name=? ";
            String name = " '' or 1=1 ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("t_name"));
            }

            //反向验证：statement容易被sql注入
            String sql1 = "select * from teacher where t_name="+name;
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql1);
            while (rs.next()) {
                System.out.println(rs.getString("t_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
