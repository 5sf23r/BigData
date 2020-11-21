package cn.commandoptionesc.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 控制缓存：
 * 不使用缓存
 */
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //不使用缓存
        response.setDateHeader("Expires",-1);//1970-01-01
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-control","no-cache");
        Date date = new Date();
        String time = date.toLocaleString();
        response.getWriter().write("time:"+time);
    }
}
