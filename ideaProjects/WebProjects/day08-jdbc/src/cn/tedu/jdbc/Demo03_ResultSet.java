package cn.tedu.jdbc;

import cn.tedu.utils.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo03_ResultSet {

    public static void main(String[] args) {
        Connection connection = C3P0Util.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("select * from teacher",
                    ResultSet.TYPE_FORWARD_ONLY,/*向前查找结果集*/
                    ResultSet.CONCUR_READ_ONLY);/*只读*/
            rs = ps.executeQuery();
            while(rs.previous()){
                System.out.println(rs.getString("t_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Util.close(rs,ps,connection);
        }

    }

}
