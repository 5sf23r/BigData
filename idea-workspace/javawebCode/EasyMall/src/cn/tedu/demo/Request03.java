package cn.tedu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request03")
public class Request03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我接受到了request02转发过来的请求，");
        System.out.println("我需要做出响应");
        //向浏览器发送一个响应
        //resp.getWriter().write("。。。$10000");
        System.out.println("request03....start");
        req.getRequestDispatcher("/request04").forward(req,resp);
        System.out.println("request03....end");
    }
}
