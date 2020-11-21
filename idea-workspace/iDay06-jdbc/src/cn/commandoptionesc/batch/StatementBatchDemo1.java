package cn.commandoptionesc.batch;

import cn.commandoptionesc.utils.JDBCUtils1;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Statement批处理
 * 优点：1. 执行效率较高
 *       2. sql语句已经预留在内存中可以重复使用。
 *       3. 有预编译功能。
 * 缺点：不能处理不同语义的sql语句
 */
public class StatementBatchDemo1 {
    /*
    create table t1(id int,name varchar(20));
    insert into v1 values(1,'阿一');
    insert into t1 values(2,'阿二');
    insert into t1 values(3,'阿三');
    insert into t1 values(4,'阿四');
     */
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            conn = JDBCUtils1.getConnection();
            stat = conn.createStatement();
            //批处理
            stat.addBatch("create table v1(id int,name varchar(20))");
            stat.addBatch("insert into v1 values(1,'阿一')");
            stat.addBatch("insert into v1 values(2,'阿二')");
            stat.addBatch("insert into v1 values(3,'阿三')");
            stat.addBatch("insert into v1 values(4,'阿四')");
            //通知数据库服务器sql语句已经准备完成
            //请执行当前批处理
            stat.executeBatch();
            System.out.println("执行成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils1.close(null,stat,conn);
        }
    }
}
