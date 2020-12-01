package com.easymall.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//注销用户登录状态
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //注销用户登陆状态可以将session删除，删除session后其中的属性值也会注销
        //实现用户注销的功能
        request.getSession(false).invalidate();
        response.sendRedirect("http://www.easymall.com");
    }
}
