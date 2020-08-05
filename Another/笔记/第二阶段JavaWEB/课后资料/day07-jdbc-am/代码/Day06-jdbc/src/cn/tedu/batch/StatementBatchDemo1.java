package cn.tedu.batch;

import java.sql.Connection;
import java.sql.Statement;

import cn.tedu.utils.JDBCUtils;

/**
 * Statement批处理
 * 	优点：可以处理不同语义的sql语句。
 *  缺点：1.执行效率低下。
 *  	2.sql语句无法预留在数据库服务器中，
 *  	每次都是新发送一条sql语句到达数据库。数据库需要重新解读sql语句。
 *  	3.没有预编译功能。
 * @author Administrator
 *
 */
public class StatementBatchDemo1 {
	/*
	 	create table t1(id int,name varchar(20));
	 	insert into t1 values(1,'阿一');
	 	insert into t1 values(2,'阿二');
	 	insert into t1 values(3,'阿三');
	 	insert into t1 values(4,'阿四');
	 * */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = JDBCUtils.getConnection();
			stat = conn.createStatement();
			//批处理过程
			stat.addBatch("create table t1(id int,name varchar(20))");
			stat.addBatch("insert into t1 values(1,'阿一')");
			stat.addBatch("insert into t1 values(2,'阿二')");
			stat.addBatch("insert into t1 values(3,'阿三')");
			stat.addBatch("insert into t1 values(4,'阿四')");
			//通知数据库服务器sql语句已经准备完成
			//请执行当前批处理。
			stat.executeBatch();
			System.out.println("执行成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, stat, conn);
		}
	}

}
