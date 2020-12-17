package cn.tedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/Cookie02")
public class Cookie02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取浏览器端的cookie数据
        //通过request请求获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookies!=null && cookies.length>0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();//获取cookie中的key
                String value = cookie.getValue();//获取cookie中的value值
                System.out.println("解码之前："+value);
                value = URLDecoder.decode(value,"utf-8");
                System.out.println("解码之后："+value);
                //1.4 获取cookie的路径
                System.out.println("cookie的路径："+cookie.getPath());
                System.out.println("name:"+name+"   value:"+value);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
