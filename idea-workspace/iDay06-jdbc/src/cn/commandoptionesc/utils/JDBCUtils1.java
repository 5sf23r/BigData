package cn.commandoptionesc.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 创建连接和关闭资源的工具类
 * 工具类中一般是通过类名.方法的形式来调用其中的方法的
 */
public class JDBCUtils1 {
    private JDBCUtils1(){

    }
    private static Properties prop = null;
    //由于配置文件只需要读取一次即可，所以将读取配置文件的过程书写在一个静态代码块中，这样在类加载的时候就会读取一个配置信息，并且保留在内存中，可以避免重复读取
    static{
        prop = new Properties();
        try {
            prop.load(new FileInputStream
                    (new File(JDBCUtils1.class.getClassLoader().getResource("conf.properties").getPath())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 创建连接
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        Class.forName(prop.getProperty("driver"));
        return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),null);
    }
    /**
     * 关闭资源
     */
    public static void close(ResultSet rs, Statement stat, Connection conn){
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
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                conn = null;
            }
        }
    }
}
