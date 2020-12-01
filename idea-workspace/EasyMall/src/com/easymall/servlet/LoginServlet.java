package com.easymall.servlet;

import com.easymall.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//登陆功能
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 乱码处理
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //2. 获取用户信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remname = request.getParameter("remname");
        //如果remname值为true则要求记住用户名
        if("true".equals(remname)){
            //为true要求保存用户名
            Cookie cookie = new Cookie("remname", URLEncoder.encode(username,"utf-8"));
            cookie.setMaxAge(60*60*24*30);
            cookie.setPath(request.getContextPath()+"/");
            response.addCookie(cookie);
        }else{
            //如果不为true则应该销毁cookie
            Cookie cookie = new Cookie("remname","");
            cookie.setMaxAge(0);
            cookie.setPath(request.getContextPath()+"/");
            response.addCookie(cookie);
        }
        //3. 访问数据库，比对用户信息
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement("select * from user where username = ? and password = ?");
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                //登陆操作
                //如果一致则保存用户登录信息
                //将用户的登陆信息登陆到session当中
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                //4. 回到首页
                response.sendRedirect("http://www.easymall.com");
            }else{
                //如果不一致则在页面中提示用户名或密码不正确
                request.setAttribute("msg","用户名或者密码不正确");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.close(conn,ps,rs);
        }
    }
}
