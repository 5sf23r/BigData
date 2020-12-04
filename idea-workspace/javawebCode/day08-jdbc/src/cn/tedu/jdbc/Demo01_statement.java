package cn.tedu.jdbc;

import cn.tedu.utils.C3P0Util;

import java.sql.*;

public class Demo01_statement {

    public static void main(String[] args) throws SQLException {
        //1.获取连接：C3P0连接池
        Connection conn = C3P0Util.getConnection();
        //2.创建一个statement的语句对象
        Statement sta = null;
        ResultSet rs = null;
        try {
            sta = conn.createStatement();
            //3.创建四个语句 CRUD
            String sql1 = "select * from teacher";
            String sql2 = "insert into teacher values(null,'测试用户',20)";
            String sql3 = "update teacher set t_name='测试11' where t_id=1 ";
            String sql4 = "delete from teacher where t_id=2 ";
            //4.执行sql语句
            rs = sta.executeQuery(sql1);
            int row1 = sta.executeUpdate(sql2);
            int row2 = sta.executeUpdate(sql3);
            int row3 = sta.executeUpdate(sql4);

        } catch(Exception e) {

        } finally {
            C3P0Util.close(rs,sta,conn);
        }
}}
