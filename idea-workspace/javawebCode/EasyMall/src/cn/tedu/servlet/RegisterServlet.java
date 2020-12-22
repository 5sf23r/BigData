package cn.tedu.servlet;

import cn.tedu.utils.C3P0Util;
import cn.tedu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/register") /* 页面发送过来的注册请求叫做 :register */
public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置 接收请求的编码格式，防止出现乱码
        /*0.1 以下这种方式只能对POST请求方式有效*/
        /*0.2 这句话一般放在代码的开头*/
        /*0.3  该方法只能解析 请求正文的参数，也就是对地址栏的参数无效 */
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /*0.4 以下的这种方式是对get方法做的专门的处理*/
        /*要求是：要使用此方法，必须先拿到参数信息
        * 此方法：无论get方法还是post方式都有效
        * */
        //String username = WebUtils.encoding(request.getParameter("username"),"utf-8");
        String username = request.getParameter("username");
        //1.获取注册表单的数据
        /*参数表示的是：页面 <input name="这是参数的值" />*/
        //String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String valistr = request.getParameter("valistr");
        /*打桩测试：输出获取的信息*/
        System.out.println(username);
        System.out.println(password);
        System.out.println(password2);
        System.out.println(nickname);
        System.out.println(email);
        System.out.println(valistr);
        //2.非空校验
        if(WebUtils.isNull(username)){
            //如果为空时，打印输出提示信息，不能为空
            System.out.println("用户名不能为空");
            //1.需要把错误提示信息添加到request对象中
            request.setAttribute("errorMsg1","用户名不能为空");

            //页面的转发：把请求转发到jsp页面中
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            //return 直接中断代码
            return;
        }
        if(WebUtils.isNull(password)){
            System.out.println("密码不能为空");
            request.setAttribute("errorMsg2","密码不能为空");

            //页面的转发：把请求转发到jsp页面中
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        //3.密码一致性校验
        if(!password.equals(password2)){
            System.out.println("两次密码输入不一致");
            request.setAttribute("errorMsg6","确认密码不能为空");

            //页面的转发：把请求转发到jsp页面中
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        if(WebUtils.isNull(nickname)){
            System.out.println("昵称不能为空");
            request.setAttribute("errorMsg3","昵称不能为空");

            //页面的转发：把请求转发到jsp页面中
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        if(WebUtils.isNull(email)){
            System.out.println("邮箱不能为空");
            request.setAttribute("errorMsg4","邮箱不能为空");

            //页面的转发：把请求转发到jsp页面中
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        //4.邮箱的格式校验
        String reg = "\\w+@+\\w+(\\.\\w+)+";
        if(!email.matches(reg)){
            System.out.println("邮箱格式不正确");
            request.setAttribute("errorMsg4","邮箱格式不正确");

            //页面的转发：把请求转发到jsp页面中
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        if(WebUtils.isNull(valistr)){
            System.out.println("验证码不能为空");
            request.setAttribute("errorMsg5","验证码不能为空");

            //页面的转发：把请求转发到jsp页面中
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }else{
            //验证码不为空时，需要判断验证码是否正确
            //1. 从session中获取一个正确的code
            String newcode = (String)request.getSession().getAttribute("valistr");
            if(!valistr.equalsIgnoreCase(newcode)){
                //错误信息的绑定
                request.setAttribute("errorMsg5","验证码输入错误");
                //把错误信息转发到注册页面中
                request.getRequestDispatcher("/regist.jsp").forward(request,response);
                return ;
            }
        }
        //5.数据库查询是否存在该用户
        Connection connection = C3P0Util.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user where username=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if(rs.next()){
                //  如果存在，不执行插入操作
                System.out.println("用户名已经注册了，注册失败");
                request.setAttribute("errorMsg1","用户名已经存在");

                //页面的转发：把请求转发到jsp页面中
                request.getRequestDispatcher("/regist.jsp").forward(request,response);
                return;
            }else{
                //  如果不存在，执行插入操作
                String sql1 = "insert into user values(null,?,?,?,?)";
                ps = connection.prepareStatement(sql1);
                ps.setString(1,username);
                ps.setString(2,password);
                ps.setString(3,nickname);
                ps.setString(4,email);
                ps.executeUpdate();
                System.out.println("用户注册成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Util.close(rs,ps,connection);
            System.out.println("释放连接池");
        }
        //6.登陆的页面跳转
        //response.sendRedirect("/index.jsp");
        //使用定时刷新
        response.getWriter().write("<h1><font color='red'>注册成功，3秒后跳转主界面</font></h1>");
        response.setHeader("refresh","3;url=http://www.easymall.com");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
