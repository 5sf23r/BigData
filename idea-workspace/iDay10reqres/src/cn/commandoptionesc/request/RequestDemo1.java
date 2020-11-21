package cn.commandoptionesc.request;

import java.io.IOException;
/**
 * 请求当中包含的客户端参数
 * 获取客户端参数的API
 */
public class RequestDemo1 extends javax.servlet.http.HttpServlet {
    // getRequestURL方法 -- 返回客户端发出请求完整URL
    // getRequestURL方法 -- 返回请求行中的资源名部分
    // getQueryString方法 -- 返回请求行中的参数部分
    // getRemoteAddr方法 -- 返回发出请求的客户机的IP地址
    // getMethod -- 得到客户机请求方式
    // getContextPath -- 获得当前web应用虚拟目录名称 -- 在写路径时不要将web应用的
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String url = request.getRequestURL().toString();
        System.out.println("url:"+url);
        String uri = request.getRequestURI().toString();
        System.out.println("uri:"+uri);
        String qs = request.getQueryString();
        System.out.println("qs:"+qs);
        String ip = request.getRemoteAddr();
        System.out.println("ip:"+ip);
        String method = request.getMethod();
        System.out.println("method:"+method);
        String cp = request.getContextPath();
        System.out.println("cp:"+cp);
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
}
