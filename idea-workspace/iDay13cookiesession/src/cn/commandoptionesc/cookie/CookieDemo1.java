package cn.commandoptionesc.cookie;

import java.io.IOException;
import java.util.Date;

//在浏览器中回显用户上次访问页面的时间
public class CookieDemo1 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //产生一个时间值
        Date date = new Date();
        String time = date.toLocaleString();
        //实现cookie
        //1. 设置setcookie响应头
        response.setHeader("set-cookie",time);
        //2. 获取一个请求头cookie
        String cookie = request.getHeader("cookie");
        //用户是第一次访问当前页面，则在浏览器中没有cookie请求头，所以无法获取到上次访问的时间
        if(cookie == null){
            response.getWriter().write("您是初次访问这个页面");
        }else{
            //如果不是初次访问，则在cookie请求中会读取浏览器中保留的set-ciikie响应头中上次访问到时间
            response.getWriter().write("您上次访问本页面的时间是："+cookie);
        }
    }
}
