package cn.commandoptionesc.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发实现
 * 与RequestDemo5一组
 */
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //请求转发
            //获取一个调度器
            RequestDispatcher rd = request.getRequestDispatcher("/servlet/RequestDemo5");
            //利用调度器实现请求转发
            rd.forward(request,response);
        }
}
