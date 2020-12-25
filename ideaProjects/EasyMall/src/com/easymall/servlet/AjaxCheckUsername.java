package com.easymall.servlet;

import com.easymall.utils.C3P0Util;
import com.easymall.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/AjaxCheckUsername")
public class AjaxCheckUsername extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //目标：检查用户名是否已经存在
        //1. 设置请求与响应的编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //2. 获取请求中的参数
        String username = request.getParameter("username");
        System.out.println("======"+username);
        // 2.1 非空校验
        if (WebUtils.isNull(username)) {
            //因为ajax是局部刷新页面，所以不能使用 转发、重定向
            response.getWriter().write("用户名不能为空");
            return;
        }
        //3. 判断数据库中是否存在该用户
        Connection connection = C3P0Util.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user where username=? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if (rs.next()) {//用户名已存在
                //因为ajax是局部刷新页面，所以不能使用 转发、重定向
                response.getWriter().write("用户名已存在");
            } else {//用户名可以使用
                //因为ajax是局部刷新页面，所以不能使用 转发、重定向
                response.getWriter().write("用户名可以使用");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Util.close(rs,ps,connection);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
