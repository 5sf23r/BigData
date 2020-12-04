package cn.tedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Cookie04")
public class Cookie04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //1.单独获取cookie5这个对象
        Cookie[] cookies = request.getCookies();
        if (cookies!=null && cookies.length>0 ) {
            for (Cookie cookie : cookies){
                if ("msg5".equals(cookie.getName())) {
                    cookie.setMaxAge(0);//删除cookie
                    //cookie的属性发生变化，重新响应给浏览器
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
