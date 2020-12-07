package com.easymall.servlet;

import com.easymall.util.C3P0Util;
import com.easymall.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //2.获取请求中的参数值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remname = request.getParameter("remname");
        System.out.println(username);
        System.out.println(password);
        System.out.println(remname);
        if (WebUtils.isNull(remname)) {//【没有勾选】记住用户名
            //没有勾选，意味着cookie不存在 ，也就是cookie清除即可
            Cookie cookie = new Cookie("remname", "");
            cookie.setMaxAge(0);
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
        } else {//【勾选了】记住用户名
            //勾选了，意味着cookie存在，需要生成一个cookie对象，存放登录信息
            Cookie cookie = new Cookie("remname", URLEncoder.encode(username,"utf-8"));
            cookie.setMaxAge(60*60*7);
            cookie.setPath(request.getContextPath()+"/");
            response.addCookie(cookie);
        }
        //3.判断数据库中，用户名和密码是否真确
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user where username=? and password=? ";
        try {
            connection = C3P0Util.getConn();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                response.sendRedirect("/index.jsp");
            } else {
                request.setAttribute("errorMsg", "用户名或者密码不正确");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
