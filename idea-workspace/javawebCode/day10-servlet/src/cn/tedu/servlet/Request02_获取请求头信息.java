package cn.tedu.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/request02")
public class Request02_获取请求头信息 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * getHeader(name)方法 --- String
         * getHeaders(String name)方法 --- Enumeration<String>
         * getHeaderNames方法 --- Enumeration<String>
         * getIntHeader(name)方法 --- int
         * getDateHeader(name)方法 --- long(日期对应毫秒)
         */
        //获取请求头中的信息
        /*   Host: localhost
        * getHeader(name) : name表示字符串类型的key ，返回值是字符串类型value
        * */
        String host = req.getHeader("Host");
        System.out.println(host);
        String accept = req.getHeader("Accept");
        System.out.println(accept);

        /*
        *  getHeaders(String name)方法 --- Enumeration<String>
            获取多个同名的请求头对应的内容
        * */
        Enumeration<String> headers = req.getHeaders("Host");
        while(headers.hasMoreElements()){
            String string = (String)headers.nextElement();
            System.out.println("head:"+string);
        }

        //这是返回了一个所有的请求头信息，枚举类型的集合
        Enumeration<String> headerNames = req.getHeaderNames();
        //判断集合是否存在元素
        while (headerNames.hasMoreElements()) {
            //获取元素对象，返回值是 请求头的key
            String headerName = headerNames.nextElement();
            String value = req.getHeader(headerName);
            System.out.println("head:"+headerName+"   value:"+value);
        }

        /* Upgrade-Insecure-Requests：1 value值是int类型
        *  getIntHeader(name)  --- 返回值int
        * */
        int intHeader = req.getIntHeader("Upgrade-Insecure-Requests");
        System.out.println("int类型的值："+intHeader);

        /*
        * getDateHeader(name)  --- 返回值 date的 long类型（毫秒数）
        * */
        long dateHeader = req.getDateHeader("Date");
        System.out.println("测试："+dateHeader);
    }
}
