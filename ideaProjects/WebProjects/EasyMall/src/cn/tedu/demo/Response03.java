package cn.tedu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Response03")
public class Response03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置请求的编码格式:POST方式
        request.setCharacterEncoding("utf-8");
        //2. 设置响应的编码格式
        //服务器端的编码
        response.setCharacterEncoding("utf-8");
        //通知浏览器使用utf-8解析
        response.setContentType("text/html;charet=utf-8");
        //3. 使用字符流响应给浏览器一段html代码
        response.getWriter().write("<h1><font color='red'>注册成功，3秒后跳转到主界面</font></h1>");
        //4. 使用refresh设置响应头的刷新时间
        response.setHeader("refresh","3;url=http://www.easymall.com");
    }
}
