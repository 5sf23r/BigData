package cn.commandoptionesc.pool;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 作为连接池上使用
 */
public class MyPool implements DataSource {
    //主要目的：为了存储初始化的5个链接
    public static List<Connection> pool = new LinkedList<Connection>();
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for(int i = 0;i<5;i++) {
                //由于每次都会执行getConnecton方法所以一定会有五个不同的对象存储在pool中。
                Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/mydb1?useSSL=false&servertimezone=UTC&user=root");
                pool.add(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * 获取一个链接
     */
    @Override
    public Connection getConnection() throws SQLException {
        Connection conn1 = null;
        //利用pool.size()获取连接池数量，如果位零则证明已经取空，需要在初始化一批连接。
        if(pool.size()>0) {
            //remove会将当前指定下标的元素删除，并且作为返回值返回
            conn1 = pool.remove(0);
        }else{
            for(int i = 0;i<5;i++) {
                //由于每次都会执行getConnecton方法所以一定会有五个不同的对象存储在pool中。
                Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/mydb1?useSSL=false&servertimezone=UTC&user=root");
                pool.add(conn);
            }
            conn1 = pool.remove(0);
        }
        System.out.println("已经从池中取出一个连接，现在池中生下："+pool.size()+"个链接");
        return conn1;
    }

    /**
     *
     * 归还连接
     * conn:用户归还的连接对象
     */
    public void returnConnection(Connection conn) throws SQLException{
        //归还连接时要保证连接是正常使用开着的，而且不能为null。
        if(conn != null && !conn.isClosed())
            pool.add(conn);
            System.out.println("归还成功,当前连接池中还剩："+pool.size()+"个连接");
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
