package cn.tedu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Response01")
public class Response01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.response对象中的状态码：302是表示重定向
        //参数值是一个int类型的变量
        response.setStatus(302);
        //2.重定向到url：http://www.baidu.com
        //response.sendRedirect("http://www.baidu.com");
        //3.如果自己做项目时，是同一个web工程之间的页面跳转
        response.sendRedirect("/index.jsp");
    }
}
