package cn.tedu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response01")
public class Response01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.response对象中的状态码：302是表示重定向
        resp.setStatus(302);//参数值是一个int类型的变量
        //2.重定向到url：http://www.baidu.com
        //resp.sendRedirect("http://www.tmooc.cn");
        //3.如果自己做项目时，是同一个web工程之间的页面跳转
        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
