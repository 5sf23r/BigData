package cn.tedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request03")
public class Request03_获取请求中的参数 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求对象 req的编码格式为 utf-8
        req.setCharacterEncoding("utf-8");
        //设置响应队形  resp的编码格式为 utf-8
        resp.setContentType("text/html;charset=utf-8");

        //获取请求中的参数信息：key=value ，获取结果为value
        /*模拟一个场景：注册信息的获取*/
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        if ("tony".equals(username)) {//如果注册用户名是tony
            resp.getWriter().write("注册失败，tony已经存在了");
        } else {
            resp.getWriter().write("注册成功了");
        }

    }
}
