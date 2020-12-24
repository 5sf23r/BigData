package cn.tedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet03_HttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //程序员自己处理的代码逻辑，可以被重复的调用
        String method = req.getMethod();
        System.out.println("执行了do"+method+"方法："+method);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this.doGet(req, resp);
        String method = req.getMethod();
        System.out.println("执行了doPost方法："+method);
    }
}
