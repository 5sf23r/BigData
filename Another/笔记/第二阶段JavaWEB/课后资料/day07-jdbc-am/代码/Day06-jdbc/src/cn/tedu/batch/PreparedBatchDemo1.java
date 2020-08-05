package cn.tedu.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.tedu.utils.JDBCUtils;

/**
 * PreparedStatement批处理：
 * 	优点：1.执行效率较高
 * 		2.sql语句已经预留在内存中可以重复使用。
 *      3.有预编译功能。
 *  缺点：不能处理不同语义的sql语句。
 * @author Administrator
 *
 */
public class PreparedBatchDemo1 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement("insert into t1 values(?,?)");
			for(int i=0;i<100199;i++){
				ps.setInt(1, i);
				ps.setString(2, "name"+i);
				ps.addBatch();
				if(i%1000 == 0){
					//满1000条执行批处理
					ps.executeBatch();
					//将执行完成的数据释放,避免内存溢出。
					ps.clearBatch();
					System.out.println("第"+i/1000+"次成功");
				}
			}
			//如果数据中有不满1000的，为了保证数据都可以执行需要最后执行一遍executeBatch()
			ps.executeBatch();
			System.out.println("全部处理成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, ps, conn);
		}
	}
	
	
	
	

}
