package cn.tedu.utils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.*;

public class C3P0Util {
        /**
         * 1.定义成员变量
         */
        private static DataSource ds;

        /**
         * 2.读取配置文件
         */
        static{
            ds = new ComboPooledDataSource();
        }

        /**
         * 3.获得连接
         */
        public static Connection getConnection()  {
            Connection conn = null;
            try {
                conn = ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }

        /**
         * 4.释放连接
         */
        public static void close(PreparedStatement pstmt, Connection conn){
            close(null,pstmt,conn);

        }
        public static void close(ResultSet rs, Statement pstmt, Connection conn){
            if(rs!=null){
                try {
                    rs.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(pstmt!=null){
                try {
                    pstmt.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

}
