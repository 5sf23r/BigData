package cn.tedu.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/ServletContext01")
public class ServletContext01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取一个ServletContext对象
        // 1.1 直接获取
        ServletContext servletContext = this.getServletContext();
        // 1.2 间接获取
        ServletContext servletContext1 = this.getServletConfig().getServletContext();
        //得出一个劲结论：ServletContext对象在web应用活动期间，内存只有一个
        System.out.println(servletContext == servletContext1);
        //2. ServletContext对象获取配置信息 ----> web.xml文件中
        // 该配置信息是全局的，所有的servlet对象都能够获取到
        String encoding = servletContext.getInitParameter("encoding");
        System.out.println(encoding);
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = servletContext.getInitParameter(name);
            System.out.println("name:"+name+"   value:"+value);
        }
        //3. servletContext对象，配置、删除、获取、共享的信息kty=value
        // 3.1 设置一个Attribute键值对的属性
        servletContext.setAttribute("success","这只成功");
        servletContext.setAttribute("success1","设置成功1");
        servletContext.setAttribute("success2","设置成功2");
        // 3.2 删除某一个Attribute键值对的属性
        servletContext.removeAttribute("success2");
        // 3.3 获取某一个Attribute键值对的属性
        String success =(String) servletContext.getAttribute("success");
        String success1 =(String) servletContext.getAttribute("success1");
        // 3.4 获取所有的Attribute键值对的属性
        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String name = attributeNames.nextElement();
            //因为该对象是全局的对象，默认会加载更多的Attribute键值对的属性
            //所以如果强转，会出现一个500的代码错误，提示强转失败
            //String value = (String) servletContext.getAttribute(name);
            //System.out.println("name:"+name+"    value:"+value);
            System.out.println("name:"+name+"    value:");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
