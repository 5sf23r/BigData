package cn.commandoptionesc.sconfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class SConfigDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //当前方法可以获取一个ServletConfig类型的对象
        ServletConfig config = this.getServletConfig();
        //获取当前SConfgDemo2的初始化配置信息
        String key = config.getInitParameter("key");
        System.out.println("key:"+key);
        Enumeration<String> names = config.getInitParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println("name:"+name);
        }
    }
}
