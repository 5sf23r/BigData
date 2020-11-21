package cn.commandoptionesc.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 获取请求中的头信息
 */
public class RequestDemo2 extends HttpServlet {
    // getHeader(name)方法 --- String
    // getHeaders(String name)方法 --- Enumeration<String>
    // getHeaderNames方法 --- Enumeration<String>
    // getIntHeader(name)方法 --- int
    // getDateHeader(name)方法 --- long(日期对应毫秒)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String host = request.getHeader("Host");
        System.out.println("host:"+host);

        //getHeaders方法可以获取多个同名的请求头对应的内容
        //这些内容会放入一个迭代器中，可以通过遍历循环获取
        Enumeration<String> headers = request.getHeaders("Host");
        while(headers.hasMoreElements()){
            String string = (String)headers.nextElement();
            System.out.println("head:"+string);
        }
        //获取全部的请求头
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            //遍历全部请求头的名称
            String string = (String)headerNames.nextElement();
            //根据请求头获取全部头对应的值
            String value = request.getHeader(string);
            System.out.println("header"+string+">>>>value:"+value);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
