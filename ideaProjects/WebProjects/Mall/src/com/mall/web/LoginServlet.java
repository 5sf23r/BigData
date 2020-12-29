package com.mall.web;

import com.mall.domain.User;
import com.mall.service.UserService;
import com.mall.utils.MD5Utils;
import com.mall.utils.WebUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("utf-8");
        //response.setContentType("text/html;charset=utf-8");
        //1. 获取页面中的form表单的数据：username,password,remname
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remname = request.getParameter("remname");
        String autologin = request.getParameter("autologin");
        System.out.println(username);
        System.out.println(password);
        System.out.println(remname);
        System.out.println(autologin);
        System.out.println(request.getContextPath());
        if (WebUtils.isNull(username)) {
            //如果为空时，打印输出提示信息，不能为空
            System.out.println("用户名不能为空");
            //1.需要把错误提示信息添加到request对象中
            request.setAttribute("errorMsg1","用户名不能为空");

            //页面的转发：把请求转发到jsp页面中
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            //return 直接中断代码
            return;
        }
        if (WebUtils.isNull(password)) {
            System.out.println("密码不能为空");
            //1.需要把错误提示信息添加到request对象中
            request.setAttribute("errorMsg2","密码不能为空");

            //页面的转发：把请求转发到jsp页面中
            request.getRequestDispatcher("/login.jsp").forward(request,response);

            return;
        }
        //2. 判断remname是否勾选了，是否为null
        //2.1 如果没有勾选 【记住用户名】，意味着cookie不存在，也就是cookie清除即可
        if(WebUtils.isNull(remname)){
            // 2.1 如果为null，表示不记住用户名，删除原有的cookie或者如果没有，不需要生成新的cookie
            Cookie cookie = new Cookie("rename","");
            cookie.setMaxAge(0);
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
        }else{
            //进行utf-8的编码，防止中文的出现错误
            String value = URLEncoder.encode(username, "utf-8");
            // 2.2 如果不为null，并且原来有cookie，需要把username重新复制给cookie；如果没有cookie，需要生成一个新的cookie，响应诶浏览器
            Cookie cookie = new Cookie("rename",URLEncoder.encode(username,"utf-8"));
            cookie.setMaxAge(60*60*24*30);
            cookie.setPath(request.getContextPath()+"/");
            response.addCookie(cookie);
        }
        //判断30天内是否自动登录
        if(WebUtils.isNull(autologin)){
            Cookie cookie = new Cookie("autologin","");
            cookie.setMaxAge(0);
            cookie.setPath(request.getContextPath()+"/");
            response.addCookie(cookie);
        }else{
            Cookie cookie = new Cookie("autologin",URLEncoder.encode(username,"utf-8")+"#"+MD5Utils.md5(password));
            //存活一个月
            cookie.setMaxAge(60*60*24*30);
            cookie.setPath(request.getContextPath()+"/");
            response.addCookie(cookie);
        }
        /*
        * UserSerive负责接收domain提供的数据
        * UserService提供处理数据的方法
        * */
        //3. 判断数据库中，用户名和密码是否正确
        UserService service = new UserService();
        //将登陆功能的返回结果作为保存用户登录信息使用，所以需要返回值对象
        User user = service.login(username, MD5Utils.md5(password));
        if(user == null){
            request.setAttribute("errorMsg","用户名或者密码不正确");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else{
            //将用户信息保存进入session域
            request.getSession().setAttribute("user",user);
            //response.sendRedirect("/index.jsp");
            response.sendRedirect(request.getContextPath()+"/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
