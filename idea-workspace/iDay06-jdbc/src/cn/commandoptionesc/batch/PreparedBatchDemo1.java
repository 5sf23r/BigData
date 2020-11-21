package cn.commandoptionesc.batch;

import cn.commandoptionesc.utils.JDBCUtils1;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * PreparedStatement批处理
 * 优点：可以处理不同语义的sql语句
 * 缺点：1. 执行效率低下
 *       2. sql语句无法预留在数据库服务器中，每次都是发送一条sql语句到达数据库。数据库需要重新解读sql语句。
 *       3. 没有预编译功能。
 */
public class PreparedBatchDemo1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils1.getConnection();
            ps = conn.prepareStatement("insert into v1 values(?,?)");
            for(int i = 0;i<100199;i++){
                ps.setInt(1,i);
                ps.setString(2,"name"+i);
                ps.addBatch();
                if(i%1000 == 0){
                    //满1000条执行批处理
                    ps.executeBatch();
                    //将执行完成的数据库释放，避免内存溢出
                    ps.clearBatch();
                    System.out.println("第"+i/1000+"次成功");
                }
            }
            //如果数据中有不满1000的，为了保证数据都可以执行需要最后执行一遍executeBatsh()
            ps.executeBatch();
            System.out.println("全部处理成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtils1.close(null,ps,conn);
        }
    }
}
