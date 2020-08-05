package cn.tedu.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.tedu.utils.JDBCUtils;

/**
 * PreparedStatement������
 * 	�ŵ㣺1.ִ��Ч�ʽϸ�
 * 		2.sql����Ѿ�Ԥ�����ڴ��п����ظ�ʹ�á�
 *      3.��Ԥ���빦�ܡ�
 *  ȱ�㣺���ܴ���ͬ�����sql��䡣
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
					//��1000��ִ��������
					ps.executeBatch();
					//��ִ����ɵ������ͷ�,�����ڴ������
					ps.clearBatch();
					System.out.println("��"+i/1000+"�γɹ�");
				}
			}
			//����������в���1000�ģ�Ϊ�˱�֤���ݶ�����ִ����Ҫ���ִ��һ��executeBatch()
			ps.executeBatch();
			System.out.println("ȫ������ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, ps, conn);
		}
	}
	
	
	
	

}
