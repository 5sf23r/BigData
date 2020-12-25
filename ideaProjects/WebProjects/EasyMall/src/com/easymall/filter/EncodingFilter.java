package com.easymall.filter;

import  javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter",value = "/*")
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //设置响应的编码格式
        resp.setContentType("text/html;charset=utf-8");
        //设置请求的编码格式：请求的方式：GET/POST，还需要考虑其他物种请求方式
        /*设计思路：
        * 1. 使用字节流获取参数，并进行编码：new String(value.getBytes("iso-8859-1"),"utf-8")
        *
        * */
        MyHttpServletRequest request = new MyHttpServletRequest((HttpServletRequest) req);
        System.out.println("测试过滤器："+request.getParameter("username"));
        //过滤器链的放行方法，一般放在过滤器的最后一句，因为过滤的业务逻辑，是要在放行之前就要处理好的
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
