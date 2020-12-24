package cn.tedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Cookie03")
public class Cookie03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //1.创建一个cookie对象，并设置数据
        // 参数：是key=vaue的键值对
        Cookie cookie1 = new Cookie("msg1","hello cy1");
        Cookie cookie2 = new Cookie("msg2","hello cy2");
        Cookie cookie3 = new Cookie("msg3","hello cy3");
        Cookie cookie4 = new Cookie("msg4","hello cy4");
        Cookie cookie5 = new Cookie("msg5","hello cy5");
        //1.1设置cookie的存活时间
        cookie1.setMaxAge(60*2);//两分钟
        cookie2.setMaxAge(60*60);//一小时
        cookie3.setMaxAge(60*60*24);//一天
        cookie4.setMaxAge(-1);//默认值：不持久化数据，浏览器关闭直接清除
        // 测试应该是：新的请求/Cookie04，设置为0，然后/Cookie02访问 获取是否删除勒
        // cookie5.setMaxAge(0);//删除一个cookie
        //2. 把cookie响应给浏览器端，
        // 其中响应过程是服务器与浏览器自动完成的，不需要程序员干预
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        response.addCookie(cookie4);
        response.addCookie(cookie5);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
