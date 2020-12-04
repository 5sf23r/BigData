package cn.tedu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(value = "/response05")
public class Response05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date = new Date();
        //使用response对象设置  控制浏览器 使用缓存
        response.setDateHeader("Expires",System.currentTimeMillis()+1000*60*60*24);
        response.setHeader("Cache-control","max-age=5");
        response.getWriter().write(date.toLocaleString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
