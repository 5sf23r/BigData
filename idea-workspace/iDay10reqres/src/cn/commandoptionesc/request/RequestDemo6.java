package cn.commandoptionesc.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发的细节：
 * 与RequestDemo7一组
 */
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求转发之前如果response缓冲区中有数据
        //则在请求转发的时候会将response缓冲区清空
        //response.getWriter().write("aaa");
        //冲刷缓冲区
        //如果在请求转发之前，冲刷response缓冲区则会造成一次响应操作
        //一旦发生一次响应操作，请求转发中的响应就无法实现。
        //因为在请求转发的模型中只能出现一次响应
        //冲刷缓冲区已经造成一次响应操作，那么请求转发中的响应就无法正常工作，导致最终报错。
        //response.flushBuffer();
        //请求转发
        request.getRequestDispatcher("/servlet/RequestDemo7").forward(request,response);
        //如果在请求转发之后冲刷缓冲区，那么为时已晚，请求转发已经做出了影响动作，不会再次执行响应操作了
        //response.getWriter().write("aaa");
        //response.flushBuffer();

    }
}
