package cn.commandoptionesc.pool;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * DBCP连接池的使用
 */
public class DBCPDemo2 {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        Properties prop = new Properties();
        prop.load(new FileReader(new File(DBCPDemo2.class.getClassLoader().getResource("dbcp.properties").getPath())));
        BasicDataSourceFactory factory = new BasicDataSourceFactory();
        DataSource source = factory.createDataSource(prop);
        try {
            conn = source.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from exam");
            while(rs.next()){
                int id = rs.getInt("id");
                int chinese = rs.getInt("chinese");
                System.out.println("id:"+id+">>>>chinese:"+chinese);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    rs = null;
                }
            }
            if(stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    stat = null;
                }
            }
            if(conn != null) {
                try {
                    //此处不是关闭连接，是归还连接
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    conn = null;
                }
            }
        }
    }
}
