package cn.tedu.pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * ��Ϊ���ӳ�ʹ��
 * @author Administrator
 *
 */
public class MyPool implements DataSource{
	//��ҪĿ�ģ�Ϊ�˴洢��ʼ����5������
	public static List<Connection> pool = new LinkedList<Connection>();
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			for(int i=0;i<5;i++){
				//����ÿ�ζ���ִ��getConnection��������һ�����������ͬ�Ķ���洢��pool�С�
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1","root","root");
				pool.add(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡһ�����ӡ�
	 */
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn1 = null;
		//����pool.size()��ȡ���ӳ����������Ϊ����֤���Ѿ�ȡ��,��Ҫ�ٳ�ʼ��һ�����ӡ�
		if(pool.size()>0){
			//remove�Ὣ��ǰָ���±��Ԫ��ɾ����������Ϊ����ֵ���ء�
			conn1 = pool.remove(0);
		}else{
			for(int i=0;i<5;i++){
				//����ÿ�ζ���ִ��getConnection��������һ�����������ͬ�Ķ���洢��pool�С�
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1","root","root");
				pool.add(conn);
			}
			conn1 = pool.remove(0);
		}
		System.out.println("�Ѿ��ӳ���ȡ��һ�����ӣ����ڳ���ʣ�£�"+pool.size()+"������");
		return conn1;
	}
	/**
	 * �黹����
	 * conn:�û��黹�����Ӷ���
	 * @throws SQLException 
	 */
	public void returnConnection(Connection conn) throws SQLException{
		
			//�黹����ʱҪ��֤����������ʹ�ÿ��ŵģ����Ҳ���Ϊnull��
			if(conn != null && !conn.isClosed() )
			pool.add(conn);
			System.out.println("�黹�ɹ�����ǰ���ӳ��л�ʣ��"+pool.size()+"������");
		
		
	}
	
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
