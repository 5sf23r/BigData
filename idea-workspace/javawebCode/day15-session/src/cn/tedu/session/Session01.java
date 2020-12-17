package cn.tedu.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Session01")
public class Session01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //1. session对象是服务器自动创建的，直接获取即可
        HttpSession session = request.getSession();
        //2. session对象是一个域对象：一次会话中有效
        // 域的范围： request  <  session   <  servletContext
        session.setAttribute("username","张三");
        session.setAttribute("list",new ArrayList<String>());
        session.setAttribute("user",new String("test"));
        session.setAttribute("array",new int[10]);
        String testkey = (String) session.getAttribute("testkey");
        System.out.println(testkey);
        List<String> list = (List<String>) session.getAttribute("list");
        System.out.println(list);

        //持久化的JSESSIONID
        System.out.println(session.getId());
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
