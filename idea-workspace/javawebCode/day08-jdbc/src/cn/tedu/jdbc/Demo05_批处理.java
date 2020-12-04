package cn.tedu.jdbc;

import cn.tedu.utils.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo05_批处理 {

    public static void main(String[] args) {
        Connection connection = C3P0Util.getConnection();
        PreparedStatement ps = null;

        try{
            String sql = "insert into teacher values (null,?,?) ";
            ps = connection.prepareStatement(sql);
            for (int i=1; i<=1000;i++) {
                ps.setString(1,"孙悟空"+i);
                ps.setInt(2,i);
                ps.addBatch();
                if (i % 100 == 0) {
                    ps.executeBatch();//批量执行100条数据
                    ps.clearBatch();//执行完毕之后清空操作
                }
            }
            //把最后一批也进行批处理
            ps.executeBatch();//批量执行100条数据
            ps.clearBatch();//执行完毕之后清空操作
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
