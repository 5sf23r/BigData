package cn.tedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*("/request01") 代表的是 浏览器发送过来的请求信息  */
@WebServlet("/request01") /*完全代替了web.xml的配置文件映射关系*/
public class Request01_获取客户机相关信息 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编写自己的业务逻辑
        /**
         * getRequestURL方法 -- 返回客户端发出请求完整URL
         *    结果：http://localhost:80/day10_servlet_war_exploded/request01
         * getRequestURI方法 -- 返回请求行中的资源名部分
         *    结果： /request01
         * getQueryString方法 -- 返回请求行中的参数部分
         *     结果： username=...&password=...
         * getRemoteAddr方法 -- 返回发出请求的客户机的IP地址
         *     结果：127.0.0.1:80
         * getMethod方法 -- 返回客户机的请求方式
         *     结果：GET/POST
         * getContextPath方法 -- 获得当前web应用的虚拟目录名称
         *      结果：/day10_servlet_war_exploded
         */
        String url = request.getRequestURL().toString();
        System.out.println("完整请求路径"+url);
        String requestURI = request.getRequestURI();
        System.out.println("资源路径："+requestURI);
        String queryString = request.getQueryString();
        System.out.println("请求行中参数："+queryString);
        String remoteAddr = request.getRemoteAddr();
        System.out.println("客户机的IP地址："+remoteAddr);
        String contextPath = request.getContextPath();
        System.out.println("虚拟目录名称："+contextPath);

    }
}
