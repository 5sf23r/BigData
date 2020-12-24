package cn.tedu.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    //定义一个properties文本的对象，专门负责解析.properties的文本
    private static Properties pros = new Properties();
    //解析的内容通过静态代码块去执行
    //因为 静态代码块 在JDBCUtil这个类加载时，就会执行，把数据写入到了内存中
    static {
        //类加载器：是java的jdk内置的
        //类的加载过程：比如JDBCUtil这个类，中的静态方法被加载内存中
                        // 这个过程就是类加载器去处理完成
        //类加载器：是可以通过其他的类也可以获取得到
        try {
            //pros.load() 会把输入流加载到pros对象中，
            //那么我们就拿到了 文本中key与value
            pros.load(JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc-config.properties"));
            System.out.println(pros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //1.获取连接的方法：返回值是connection
    public static Connection getConnection(){
        Connection connection = null;
        //1.1注册驱动程序
        try {
            /*DriverManager.registerDriver(new Driver());*/
            Class.forName(pros.getProperty("driver"));
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //2.关闭连接的方法：参数是 结果集对象、语句对象、连接对象
    public static void close (ResultSet resultSet,
                              Statement statement,
                              Connection connection) {
        //2.1先进行非空校验
        if (resultSet != null) {
            try {
                resultSet.close();/*close()方法直接有效，比null快速*/
            } catch (SQLException e) {
                e.printStackTrace();
                resultSet = null;/*这里为null时，会被jvm虚拟机回收，回收时间不确定*/
            }
        }
        if (statement!=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                statement = null;
            }
        }
        if (connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                connection = null;
            }
        }

    }

}
