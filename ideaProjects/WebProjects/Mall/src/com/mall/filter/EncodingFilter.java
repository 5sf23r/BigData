package com.mall.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
//全栈乱码处理
@WebFilter(filterName = "EncodingFilter",value="/*")
public class EncodingFilter implements Filter {
    String encode = null;
    Boolean use_encode = false;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //在返回request对象的时候判断是否使用乱码处理后的request对象
        //这是请求的编码格式：请求的方式：GET/POST，还需要考虑其他物种请求方式
        //设计思路：1. 使用字节流获取参数，并进行编码：String(value.getBytes("iso-8859-1"),"utf-8")
        ServletRequest request =use_encode? new MyHttpServletRequest((HttpServletRequest) req,encode):req;
        //设置响应的编码格式
        resp.setContentType("text/html;charset="+encode);
        //过滤器链的放行方法，一般放在过滤器的最后一句
        //因为过滤的业务逻辑，是要放行之前就要处理好的
        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encode = config.getServletContext().getInitParameter("encode");
        //是否开启字符集
        use_encode = Boolean.parseBoolean(config.getServletContext().getInitParameter("use_encode"));
    }

}
