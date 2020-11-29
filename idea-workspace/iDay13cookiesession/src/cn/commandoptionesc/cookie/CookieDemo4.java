package cn.commandoptionesc.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//删除cookie
public class CookieDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建一个name和path与要删除的完全一致的coolie，并且设置生命时长为0
        //创建cookie
        Cookie cookie = new Cookie("time","");
        //path一致
        cookie.setPath(request.getContextPath()+"/");
        //设置生命时长为0
        cookie.setMaxAge(0);
        //将cookie发送到浏览器
        response.addCookie(cookie);
    }
}
