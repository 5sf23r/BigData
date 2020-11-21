package cn.commandoptionesc.jdbc;

import cn.commandoptionesc.utils.JDBCUtils1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedDemo1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils1.getConnection();
            //发送sql语句的主干部分
            ps = conn.prepareStatement("select * from user where name = ?");
            //发送参数
            //setString(第几个问号的下标,对应下标的出入值);
            ps.setString(1,"ls");
            //此句表示sql语句的主干和参数部分都已经传递完成，继续执行当前sql语句。
            ps.executeQuery();
            while(rs.next()){
                String password = rs.getString("password");
                System.out.println("password:"+password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils1.close(rs,ps,conn);
        }
    }
}
