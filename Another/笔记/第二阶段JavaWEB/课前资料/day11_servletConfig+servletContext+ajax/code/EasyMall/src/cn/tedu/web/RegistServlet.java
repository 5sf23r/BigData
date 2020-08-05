package cn.tedu.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.tedu.utils.JDBCUtils;
import cn.tedu.utils.WebUtils;

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.解决乱码问题
			//>>响应正文乱码
			response.setContentType("text/html;charset=utf-8");
			//>>请求参数乱码
			request.setCharacterEncoding("utf-8");
			
		//2.获取请求参数(获取注册数据)
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");
			String valistr = request.getParameter("valistr");
			
		//3.数据校验 
			//>>非空校验
			if(WebUtils.isNull(username)){
				//校验不通过, 将提示消息存入request域
				request.setAttribute("msg", "用户名不能为空");
				//通过转发跳转到注册页, 并取出提示消息进行提示
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			if(WebUtils.isNull(password)){
				//校验不通过, 将提示消息存入request域
				request.setAttribute("msg", "密码不能为空");
				//通过转发跳转到注册页, 并取出提示消息进行提示
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			if(WebUtils.isNull(password2)){
				//校验不通过, 将提示消息存入request域
				request.setAttribute("msg", "确认密码不能为空");
				//通过转发跳转到注册页, 并取出提示消息进行提示
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			if(WebUtils.isNull(nickname)){
				//校验不通过, 将提示消息存入request域
				request.setAttribute("msg", "昵称不能为空");
				//通过转发跳转到注册页, 并取出提示消息进行提示
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			if(WebUtils.isNull(email)){
				//校验不通过, 将提示消息存入request域
				request.setAttribute("msg", "邮箱不能为空");
				//通过转发跳转到注册页, 并取出提示消息进行提示
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			if(WebUtils.isNull(valistr)){
				//校验不通过, 将提示消息存入request域
				request.setAttribute("msg", "验证码不能为空");
				//通过转发跳转到注册页, 并取出提示消息进行提示
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			
			//>>两次密码是否一致
			if(!password.equals(password2)){
				//校验不通过, 将提示消息存入request域
				request.setAttribute("msg", "两次密码不一致");
				//通过转发跳转到注册页, 并取出提示消息进行提示
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			
			//>>邮箱格式是否正确
			String reg = "^\\w+@\\w+(\\.\\w+)+$";
			if(!email.matches(reg)){
				//校验不通过, 将提示消息存入request域
				request.setAttribute("msg", "邮箱格式不正确");
				//通过转发跳转到注册页, 并取出提示消息进行提示
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			
			//>>验证码是否正确
			//TODO
			
			
			//>>用户名是否存在
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet  rs = null;
			//使用c3p0连接池获取连接
			try {
				//获取连接
				conn = JDBCUtils.getConn();
				String sql = "select * from user where username=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				rs = ps.executeQuery();
				if(rs.next()){//--true 表示用户名已存在
					request.setAttribute("msg", "用户名已存在!");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);
					return;
				}
				
				//4.注册用户(将注册数据保存进数据库)
				sql = "insert into user values(null, ?,?,?,?)";
				ps =  conn.prepareStatement(sql);
				
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, nickname);
				ps.setString(4, email);
				
				ps.executeUpdate();
				
				//5.注册成功, 3秒之后跳转回首页
				response.getWriter().write("<h1 style='color:red;text-align:center'>恭喜您注册成功, 3秒之后跳转回首页......</h1>");
				response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				JDBCUtils.close(conn, ps, rs);
			}
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
