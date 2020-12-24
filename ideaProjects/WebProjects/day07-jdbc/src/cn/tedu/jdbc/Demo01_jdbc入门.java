package cn.tedu.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class Demo01_jdbc入门 {

    public static void main(String[] args) throws SQLException {

        //1.注册驱动程序：也就是引入和加载mysql的驱动包
        /*特别注意：参数指的是：mysql的驱动对象
        *          参数 如果是mysql数据库  就是 new Driver();
        *               如果是oracle数据库  就是 new OracleDriver();
        * */
        //DriverManager可以支持多个不同的数据库驱动！！
        DriverManager.registerDriver(new Driver());/*快捷键：alt+enter*/
        //2.获取一个数据库连接：配置基本信息
        String user = "root";
        String password = "123456";
        /*url：使用的是jdbc的协议去连接的，连接到某一个database*/
        String url = "jdbc:mysql://localhost:3306/javaweb";
        Connection connection = DriverManager.getConnection(url, user, password);
        //3.编写sql语句，并且 先创建一个sql语句的对象
        //创建一个语句对象statement ：执行sql语句
        Statement statement = connection.createStatement();
        //4.使用statement对象去执行sql语句
        ResultSet resultSet = statement.executeQuery("select * from teacher");
        //5.循环遍历结果集
        while(resultSet.next()){//循环的行数
            //循环体：每一行的列的值
            int id = resultSet.getInt(1);/*columnIndex：列的下标，从1开始*/
            String t_name = resultSet.getString("t_name");/*columnLabel：列名*/
            System.out.println("id:"+id+"   name:"+t_name);

        }
        //6.关闭资源：按代码顺序，从下往上关
        resultSet.close();
        statement.close();
        connection.close();
    }

}
