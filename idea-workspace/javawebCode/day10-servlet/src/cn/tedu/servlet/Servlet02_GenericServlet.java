package cn.tedu.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

public class Servlet02_GenericServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        //主要的业务逻辑代码
        //实现的功能如下：在浏览器中显示当前的日期时间
        Date date = new Date();
        //如何把data日期 返回给浏览器
        System.out.println(date.toString());
        //参数一：ServletRequest 是 接受浏览器的请求
        //参数二：ServletResponse 是 响应给浏览器的结果
        //servletResponse.getWriter();它只是通过response打开一个wirter流
        servletResponse.getWriter().write(date.toString());

        //根据不同的请求，会执行不同的代码逻辑
        //1.获取浏览器的请求方式
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String method = req.getMethod();//得到http的请求方式
        System.out.println("请求方式："+method);
        if ("GET".equalsIgnoreCase(method)) {
            System.out.println("get方式的处理逻辑在这里写");
        } else if ("POST".equalsIgnoreCase(method)) {
            System.out.println("post方式的处理逻辑在这里写");
        }

    }
}
