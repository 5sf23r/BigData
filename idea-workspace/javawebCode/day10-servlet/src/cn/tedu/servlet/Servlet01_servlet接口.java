package cn.tedu.servlet;

import javax.servlet.*;
import java.io.IOException;

public class Servlet01_servlet接口 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("这是一个初始化方法，先执行init（）方法");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        System.out.println("这是service服务方法，程序员编写业务逻辑（处理请求的代码）就在这里写！！！");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("大哥....我快不行了...救救我，这是遗言！！");
    }
}
