package cn.commandoptionesc.jdbc;

import cn.commandoptionesc.utils.JDBCUtils1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 登陆功能 --- jdbc实现
 *
 */
public class Login {
    public static void main(String[] args) {
        //要求用户输入用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        loginTest(name,password);
    }

    private static void loginTest(String name, String password) {
        //将获取到的值和数据库中的数据作比对
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils1.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from user where name = '"+name+"' and password = '"+password+"'");
            if(rs.next()){
                System.out.println("登陆成功");
            }else{
                System.out.println("登陆失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils1.close(rs,stat,conn);
        }

    }
}
