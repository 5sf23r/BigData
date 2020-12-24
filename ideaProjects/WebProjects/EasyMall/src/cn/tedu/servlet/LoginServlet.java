package cn.tedu.servlet;

import cn.tedu.utils.C3P0Util;
import cn.tedu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //1. 获取页面中的form表单的数据：username,password,remname
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remname = request.getParameter("remname");
        System.out.println(username);
        System.out.println(password);
        System.out.println(remname);
        //2. 判断remname是否勾选了，是否为null
        if(WebUtils.isNull(remname)){
            // 2.1 如果为null，表示不记住用户名，删除原有的cookie或者如果没有，不需要生成新的cookie
            Cookie cookie = new Cookie("username","");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }else{
            //进行utf-8的编码，防止中文的出现错误
            String value = URLEncoder.encode(username, "utf-8");
            // 2.2 如果不为null，并且原来有cookie，需要把username重新复制给cookie；如果没有cookie，需要生成一个新的cookie，响应诶浏览器
            Cookie cookie = new Cookie("username",value);
            cookie.setValue(username);
            cookie.setMaxAge(60*60*24*30);//存活一个月
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        //3. C3P0连接池：查询数据库是否存在该用户
        Connection connection = C3P0Util.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user where username=? and password=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            // 3.1 如果存在，表示登陆成功，重定向到主界面【index.jsp】
            if(rs.next()){
                //使用session对象把用户名绑定
                request.getSession().setAttribute("username",username);
                response.sendRedirect("/index.jsp");
            }else{
                // 3.2 如果不存在，表示登陆失败，请求转发到【login.jsp】，给出提示信息
                request.setAttribute("errorMsg","用户名或者密码不正确");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            C3P0Util.close(rs,ps,connection);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
