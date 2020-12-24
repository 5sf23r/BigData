package cn.tedu.jdbc;

import cn.tedu.utils.C3P0Util;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo07_分页查询 {

    public static void main(String[] args) {
        Connection connection = C3P0Util.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        /*分页查询的sql：该语句仅限mysql使用*/
        String sql = " select * from user limit ?,? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,0);/*第一个问号：begin第几条开始，不包含当前条*/
            ps.setInt(2,8);/*第二个问号：pageSizes 一页中的数据量*/
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Util.close(rs,ps,connection);
        }

    }

}
