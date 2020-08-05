package cn.tedu.batch;

import java.sql.Connection;
import java.sql.Statement;

import cn.tedu.utils.JDBCUtils;

/**
 * Statement������
 * 	�ŵ㣺���Դ���ͬ�����sql��䡣
 *  ȱ�㣺1.ִ��Ч�ʵ��¡�
 *  	2.sql����޷�Ԥ�������ݿ�������У�
 *  	ÿ�ζ����·���һ��sql��䵽�����ݿ⡣���ݿ���Ҫ���½��sql��䡣
 *  	3.û��Ԥ���빦�ܡ�
 * @author Administrator
 *
 */
public class StatementBatchDemo1 {
	/*
	 	create table t1(id int,name varchar(20));
	 	insert into t1 values(1,'��һ');
	 	insert into t1 values(2,'����');
	 	insert into t1 values(3,'����');
	 	insert into t1 values(4,'����');
	 * */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = JDBCUtils.getConnection();
			stat = conn.createStatement();
			//���������
			stat.addBatch("create table t1(id int,name varchar(20))");
			stat.addBatch("insert into t1 values(1,'��һ')");
			stat.addBatch("insert into t1 values(2,'����')");
			stat.addBatch("insert into t1 values(3,'����')");
			stat.addBatch("insert into t1 values(4,'����')");
			//֪ͨ���ݿ������sql����Ѿ�׼�����
			//��ִ�е�ǰ������
			stat.executeBatch();
			System.out.println("ִ�гɹ���");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, stat, conn);
		}
	}

}
