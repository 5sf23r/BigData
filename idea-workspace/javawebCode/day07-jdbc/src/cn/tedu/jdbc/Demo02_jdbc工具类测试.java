package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02_jdbc工具类测试 {

    public static void main(String[] args) {
        //1.获取一个数据库连接
        Connection connection = JDBCUtil.getConnection();
        Statement statement = null;
        //2.创建一个sql语句的对象
        try {
            statement = connection.createStatement();
            //3.执行sql语句
            int rows = statement.executeUpdate
                    ("update teacher set t_age=40 where t_id=1 ");
            System.out.println("受影响的行数："+rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {/*最终的代码块：无论sql是否执行成功，都需要关闭*/
            JDBCUtil.close(null,statement,connection);
        }
    }

}
