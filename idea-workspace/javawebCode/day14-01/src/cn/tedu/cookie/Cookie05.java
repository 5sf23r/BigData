package cn.tedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/Cookie05")
public class Cookie05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //1.创建一个cookie对象
        Cookie cookie = new Cookie("username", "曹洋");
        //1.1 获取cookie中的value值
        System.out.println("编码之前："+cookie.getValue());
        //1.2 对cookie的value值进行编码
        String newvalue = URLEncoder.encode(cookie.getValue(),"utf-8");
        System.out.println("编码之后："+newvalue);
        //1.3 把newvalue赋值给cookie
        cookie.setValue(newvalue);
        //1.4 获取cookie的路径
        System.out.println(cookie.getPath());
        cookie.setPath("/");
        //2.直接响应给浏览器
        response.addCookie(cookie);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
