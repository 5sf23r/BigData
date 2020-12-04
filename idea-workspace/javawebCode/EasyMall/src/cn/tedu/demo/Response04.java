package cn.tedu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/response04")
public class Response04 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建一个日期对象
        Date date = new Date();
        //2. response对象控制浏览器 不使用缓存
        //参数-1 ：表示时间毫秒数，-1是不使用缓存
        resp.setDateHeader("Expires",-1);
        resp.setHeader("pragma","no-cache");
        resp.setHeader("Cache-control","no-cache");
        //3.把日期输出到浏览器显示
        resp.getWriter().write(date.toLocaleString());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
