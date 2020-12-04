package cn.tedu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response03")
public class Response03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置请求的编码格式:POST方式
        req.setCharacterEncoding("utf-8");
        //2.设置响应的编码格式
        resp.setCharacterEncoding("utf-8");//服务器端的编码
        resp.setContentType("text/html;charset=utf-8");//通知浏览器使用utf-8解析
        //3.使用字符流响应给浏览器一段html代码
        resp.getWriter().write("<h1><font color='red'>注册成功，3秒后跳转到主界面</font></h1>");
        //4.使用refresh 设置响应头的刷新时间
        resp.setHeader("refresh","3;url=http://www.easymall.com");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
