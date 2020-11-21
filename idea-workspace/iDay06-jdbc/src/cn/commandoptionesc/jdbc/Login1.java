package cn.commandoptionesc.jdbc;

import cn.commandoptionesc.utils.JDBCUtils1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * 登陆功能 --- jdbc实现
 *
 */
public class Login1 {
    public static void main(String[] args) {
        //要求用户输入用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        loginTestPrepared(name,password);
    }

    //Prepared实现jdbc
    private static void loginTestPrepared(String name, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils1.getConnection();
            ps = conn.prepareStatement("select * from user where name = ? and password = ?");
            ps.setString(1,name);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("登陆成功");
            }else{
                System.out.println("登陆失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils1.close(rs,ps,conn);
        }
    }
}
