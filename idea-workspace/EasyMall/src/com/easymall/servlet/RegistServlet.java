package com.easymall.servlet;

import com.easymall.utils.JDBCUtils;
import com.easymall.utils.WebUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 注册功能
 */
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //乱码处理
        //处理请求参数乱码
        request.setCharacterEncoding("utf-8");
        //处理响应乱码
        response.setContentType("text/html;charset=utf-8");

        //获取用户发送的参数信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String valistr = request.getParameter("valistr");
        //非空校验
        if(WebUtils.isNULL(username)){
            //注册页面提示：用户名称不能为空
            request.setAttribute("msg","用户名称不能为空");
            //请求转发之后当前servlet与regist.jsp页面看到的是同一块域，可以共享数据
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        if(WebUtils.isNULL(password)){
            //注册页面提示：用户名称不能为空
            request.setAttribute("msg","密码不能为空");
            //请求转发之后当前servlet与regist.jsp页面看到的是同一块域，可以共享数据
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        if(WebUtils.isNULL(password2)){
            //注册页面提示：用户名称不能为空
            request.setAttribute("msg","确认密码不能为空");
            //请求转发之后当前servlet与regist.jsp页面看到的是同一块域，可以共享数据
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        if(WebUtils.isNULL(nickname)){
            //注册页面提示：用户名称不能为空
            request.setAttribute("msg","昵称不能为空");
            //请求转发之后当前servlet与regist.jsp页面看到的是同一块域，可以共享数据
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        if(WebUtils.isNULL(email)){
            //注册页面提示：用户名称不能为空
            request.setAttribute("msg","邮箱不能为空");
            //请求转发之后当前servlet与regist.jsp页面看到的是同一块域，可以共享数据
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        if(WebUtils.isNULL(valistr)){
            //注册页面提示：用户名称不能为空
            request.setAttribute("msg","验证码不能为空");
            //请求转发之后当前servlet与regist.jsp页面看到的是同一块域，可以共享数据
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        //邮箱格式校验
        //lishuai@tide.com
        String reg = "\\w+@\\w+(\\.\\w+)+$";
        if (!email.matches(reg)) {
            request.setAttribute("msg","邮箱格式错误");
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        //密码一致性校验
        if(!password.equals(password2)){
            request.setAttribute("msg","两次密码不一致");
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        //验证码校验
        //TODO:session

        //完成注册
        //用户名存在校验
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement("select * from user where username = ?");
            ps.setString(1,username);
            rs = ps.executeQuery();
            //如果能够查询到结果则证明用户已经存在不允许注册，并且在前台页面做出提示
            if (rs.next()) {
                request.setAttribute("msg","用户名已经存在");
                request.getRequestDispatcher("/regist.jsp").forward(request,response);
                return;
            }else{
                //用户名不存在就可以将用户信息插入到数据库中
                ps = conn.prepareStatement("insert into user values(null,?,?,?,?)");
                ps.setString(1,username);
                ps.setString(2,password);
                ps.setString(3,nickname);
                ps.setString(4,email);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.close(conn,ps,rs);
        }
        //跳转回首页
        //定时刷新
        response.getWriter().write("<h1 align='center'><font color='red'>恭喜注册成功，3秒之后跳转回首页</font></h1>");
        response.setHeader("refresh","3;url=http://www.easymall.com");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
