package cn.tedu.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletConfig01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取一个ServletConfig对象
        // 该对象对应着web.xml中<servlet>中的配置信息
        //该对象只是对当前的servlet对象来说的，其他的servlet对象没有关系
        ServletConfig servletConfig = this.getServletConfig();
        //2. 使用API中的方法，获取初始化的配置信息key与value
        // 2.1 该方法参数为key，返回值为value，结果只有一个value
        String encoding = servletConfig.getInitParameter("encoding");
        System.out.println(encoding);
        request.setCharacterEncoding(encoding);
        // 2.2 该方法返回当前servlet中所有的配置信息，key:value的键值对信息
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String key = initParameterNames.nextElement();
            String value = servletConfig.getInitParameter(key);
            System.out.println("key:"+key+"    value:"+value);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
