package cn.tedu.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request01")
public class Request01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //模拟场景
        System.out.println("浏览器发送的请求，我暂时处理不了");
        System.out.println("需要交给另外一个servlet去处理");
        //1.创建一个调度器：作用是把request请求指向了另一个servlet
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/request02");
        //2. 把request对象 与 response对象 一并发送给request02
        /*主要作用，在转发过程中，分别保证请求对象、响应对象是相同的*/
        System.out.println("request01....start");
        requestDispatcher.forward(req,resp);
        System.out.println("request01....end");

    }
}
