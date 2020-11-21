package cn.commandoptionesc.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求包含实现
 * 与RequestDemo13一组
 */
public class RequestDemo12 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("aaa");
        //获取一个调度器
        //利用调度器实现请求包含
        request.getRequestDispatcher("/servlet/RequestDemo13").include(request,response);
    }
}
