package cn.tedu.utils;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.util.Properties;

public class DBCPUtil {

    private static BasicDataSource bds = null;
    //这是一个私有化的构造方法，不能new创建对象
    private DBCPUtil () {

    }
    //初始化连接池，也就是把连接池的基本信息获得
    public static void init() {
        //1.定义一个properties的对象
        Properties pros = new Properties();
        //2.通过流加载dbcp的配置文件
        try {
            pros.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcp-config.properties"));
        }catch (Exception e) {

        }
        //3.通过pros对象获取参数：配置信息
        try {
            String driver = pros.getProperty("jdbc.driver");
            String url = pros.getProperty("jdbc.url");
            String user = pros.getProperty("jdbc.user");
            String password = pros.getProperty("jdbc.password");
            String initSizes = pros.getProperty("dataSource.initialSize");
            String maxIdle = pros.getProperty("dataSource.maxIdle");
            String minIdle = pros.getProperty("dataSource.minIdle");
            String maxActive = pros.getProperty("dataSource.maxActive");
            String maxWait = pros.getProperty("dataSource.maxWait");
            //4. 创建一个连接池对象
            bds = new BasicDataSource();
            //5. 把配置信息添加到连接池对象中
            bds.setDriverClassName(driver);
            bds.setUrl(url);
            bds.setUsername(user);
            bds.setPassword(password);
            //如果没有配置连接池的信息，那么给一个默认的值
            if (initSizes==null || "".equals(initSizes)) {
                bds.setInitialSize(40);
            } else {
                bds.setInitialSize(Integer.parseInt(initSizes));
            }
            if (maxIdle==null || "".equals(maxIdle)) {
                bds.setMaxIdle(60);
            } else {
                bds.setMaxIdle(Integer.parseInt(maxIdle));
            }
            if (minIdle==null || "".equals(minIdle)) {
                bds.setMinIdle(20);
            } else {
                bds.setMinIdle(Integer.parseInt(minIdle));
            }
            if (maxActive==null || "".equals(maxActive)) {
                bds.setMaxActive(50);
            } else {
                bds.setMaxActive(Integer.parseInt(maxActive));
            }
            if (maxWait==null || "".equals(maxWait)) {
                bds.setMaxWait(1000);
            } else {
                bds.setMaxWait(Integer.parseInt(maxWait));
            }


        } catch(Exception e) {
            System.out.println("数据库连接池初始化失败");

        }

    }

    public static Connection getConnection() {
        if (bds == null) {//如果为null，需要先初始化信息
            init();//静态方法，直接调用即可，上面的方法
        }
        Connection conn = null;
        try{
            conn = bds.getConnection();
        }catch(Exception e){

        }

        return conn;
    }

    public static void main(String[] args){
        Connection conn = DBCPUtil.getConnection();
        System.out.println(conn);
    }

}
