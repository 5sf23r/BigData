package com.mall.web;

import com.mall.domain.User;
import com.mall.service.UserService;
import com.mall.utils.MD5Utils;
import com.mall.utils.WebUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register") /*页面发送过来的注册请求叫做：register*/
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setCharacterEncoding("utf-8");
        //resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String nickname = req.getParameter("nickname");
        String email = req.getParameter("email");
        String valistr = req.getParameter("valistr");
        /*打桩测试：输出获取的信息*/
        System.out.println(username);
        System.out.println(password);
        System.out.println(password2);
        System.out.println(nickname);
        System.out.println(email);
        System.out.println(valistr);
        //2.非空校验
        if (WebUtils.isNull(username)) {
            //如果为空时，打印输出提示信息，不能为空
            System.out.println("用户名不能为空");
            //1.需要把错误提示信息添加到request对象中
            req.setAttribute("errorMsg1","用户名不能为空");

            //页面的转发：把请求转发到jsp页面中
            req.getRequestDispatcher("/regist.jsp").forward(req,resp);
            //return 直接中断代码
            return;
        }
        if (WebUtils.isNull(password)) {
            System.out.println("密码不能为空");
            //1.需要把错误提示信息添加到request对象中
            req.setAttribute("errorMsg2","密码不能为空");

            //页面的转发：把请求转发到jsp页面中
            req.getRequestDispatcher("/regist.jsp").forward(req,resp);

            return;
        }
        //3.密码一致性校验
        if (!password.equals(password2)) {
            System.out.println("两次密码输入不一致");
            //1.需要把错误提示信息添加到request对象中
            req.setAttribute("errorMsg6","两次密码输入不一致");

            //页面的转发：把请求转发到jsp页面中
            req.getRequestDispatcher("/regist.jsp").forward(req,resp);
            return;
        }
        if (WebUtils.isNull(nickname)) {
            System.out.println("昵称不能为空");
            //1.需要把错误提示信息添加到request对象中
            req.setAttribute("errorMsg3","昵称不能为空");

            //页面的转发：把请求转发到jsp页面中
            req.getRequestDispatcher("/regist.jsp").forward(req,resp);
            return;
        }
        if (WebUtils.isNull(email)) {
            System.out.println("邮箱不能为空");
            //1.需要把错误提示信息添加到request对象中
            req.setAttribute("errorMsg4","邮箱不能为空");

            //页面的转发：把请求转发到jsp页面中
            req.getRequestDispatcher("/regist.jsp").forward(req,resp);
            return;
        }
        //4.邮箱的格式校验 : 123@qq.com  --> \w+@\w+(\.\w+)+
        String reg = "\\w+@\\w+(\\.\\w+)+";
        if (!email.matches(reg)) {
            System.out.println("邮箱格式不正确");
            //1.需要把错误提示信息添加到request对象中
            req.setAttribute("errorMsg4","邮箱格式不正确");

            //页面的转发：把请求转发到jsp页面中
            req.getRequestDispatcher("/regist.jsp").forward(req,resp);
            return;
        }
        if (WebUtils.isNull(valistr)) {
            System.out.println("验证码不能为空");
            //1.需要把错误提示信息添加到request对象中
            req.setAttribute("errorMsg5","验证码不能为空");

            //页面的转发：把请求转发到jsp页面中
            req.getRequestDispatcher("/regist.jsp").forward(req,resp);
            return;
        } else {
            //验证码不为空时，需要判断验证码是否正确
            //1.从session中获取一个正确的code
            String newcode = (String) req.getSession().getAttribute("valistr");
            if (!valistr.equalsIgnoreCase(newcode)) {
                //错误信息的绑定
                req.setAttribute("errorMsg5","验证输入错误");
                //把错误信息转发到注册页面上
                req.getRequestDispatcher("/regist.jsp").forward(req,resp);
                return ;
            }
        }
        //5. 想数据库插入数据
        UserService service = new UserService();
        User user = new User(username, MD5Utils.md5(password),nickname,email);
        try {
            service.registUser(user);
        }catch(Exception e) {
            e.printStackTrace();
            String msg = e.getMessage();
            req.setAttribute("errorMsg1", msg);
            req.getRequestDispatcher("/regist.jsp").forward(req, resp);
        }
        //6.登录的页面跳转：主界面跳转使用重定向
        /*resp.sendRedirect("/index.jsp");*/
        //使用定时刷新
        resp.getWriter().write("<h1><font color='red'>注册成功，3秒后跳转到主界面</font></h1>");
        resp.setHeader("refresh","3;url=http://www.easymall.com");
    }
}
