package cn.tedu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/Response04")
public class Response04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 创建一个日期对象
        Date date = new Date();
        //2. response对象控制浏览器，不适用缓存
        //参数-1：表示时间毫秒数，-1是不适用缓存
        response.setDateHeader("Expires",-1);
        response.setHeader("pragma","no-cache");
        response.setHeader("Cache-control","no=cache");
        //3. 把日期输出到浏览器显示
        response.getWriter().write(date.toLocaleString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
