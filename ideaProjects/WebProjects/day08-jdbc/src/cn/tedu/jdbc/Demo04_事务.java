package cn.tedu.jdbc;

import cn.tedu.utils.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo04_事务 {

    public static void main(String[] args) {
        Connection connection = C3P0Util.getConnection();
        PreparedStatement ps = null;
        try {
            //1.先获取事务的自动提交的状态：默认是true
            boolean flag = connection.getAutoCommit();
            //2.手动修改状态为false，也就是禁止自动提交
            connection.setAutoCommit(false);
            //模拟t_id=1的用户  减少10岁
            ps = connection.prepareStatement
                    ("update teacher set t_age=t_age-10 where t_id=1 ");
            ps.executeUpdate();
            //增加一个异常操作
            int i = 1/0;
            //模拟t_id=3的用户  增加10岁
            ps = connection.prepareStatement
                    ("update teacher set t_age=t_age+10 where t_id=3 ");
            ps.executeUpdate();
            //3.前提是：代码不报错：手动提交前面执行的所有的sql语句
            connection.commit();
            //5.最后需要把事务的手动状态恢复成自动状态
            connection.setAutoCommit(flag);
        } catch (Exception e) {
            e.printStackTrace();
            //4.如果执行了代码出现异常，进行回滚操作
            //所有的交易数据都恢复到最初的状态
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            C3P0Util.close(null,ps,connection);
        }


    }

}
