package com.mall.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //注销用户登录状态可以将session删除，删除session后其中的属性值也会销毁
        //实现用户注销的功能
        //先判断session对象是否为空，如果为空则不需要释放
        //不为空在释放
        if(request.getSession(false)!=null) {
            request.getSession(false).invalidate();
        }
        //30天内自动登录清楚cookie，避免点击之后重复登录，需要等待30天
        Cookie cookie = new Cookie("autologin","");
        cookie.setMaxAge(0);
        cookie.setPath(request.getContextPath()+"/");
        response.addCookie(cookie);
        response.sendRedirect("/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
