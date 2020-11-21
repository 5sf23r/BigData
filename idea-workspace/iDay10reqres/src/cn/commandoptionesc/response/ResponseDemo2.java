package cn.commandoptionesc.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求重定向
 */
public class ResponseDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置302状态码
        //response.setStatus(302);
        //2. 设置location响应头
        //response.setHeader("location","http://www.tmooc.cn");
        //response.setHeader("location",request.getContextPath()+"/servlet/ResponseDemo1");
        response.sendRedirect("http://www.baidu.com");
    }
}
