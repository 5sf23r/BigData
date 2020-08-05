package com.easymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easymall.domain.User;
import com.easymall.exception.MsgException;
import com.easymall.service.UserService;
import com.easymall.utils.MD5Utils;
import com.easymall.utils.WebUtils;
/**
 * 注册功能
 * @author Administrator
 *
 */
public class RegistServlet extends HttpServlet {
	private UserService userService = new UserService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//乱码处理
		//请求乱码和响应乱码处理
		/*request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");*/
		
		//获取用户发送的参数信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String valistr = request.getParameter("valistr");
		//非空校验
		if(WebUtils.isNull(username)){
			//注册页面提示：用户名称不能为空
			request.setAttribute("msg", "用户名称不能为空");
			//请求转发之后当前servlet与regist.jsp页面看到的是同一块域，可以共享数据。
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(password)){
			//注册页面提示：用户名称不能为空
			request.setAttribute("msg", "密码不能为空");
			//请求转发之后当前servlet与regist.jsp页面看到的是同一块域，可以共享数据。
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(password2)){
			//注册页面提示：用户名称不能为空
			request.setAttribute("msg", "确认密码不能为空");
			//请求转发之后当前servlet与regist.jsp页面看到的是同一块域，可以共享数据。
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(nickname)){
			//注册页面提示：用户名称不能为空
			request.setAttribute("msg", "昵称不能为空");
			//请求转发之后当前servlet与regist.jsp页面看到的是同一块域，可以共享数据。
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(email)){
			//注册页面提示：用户名称不能为空
			request.setAttribute("msg", "邮箱不能为空");
			//请求转发之后当前servlet与regist.jsp页面看到的是同一块域，可以共享数据。
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(valistr)){
			//注册页面提示：用户名称不能为空
			request.setAttribute("msg", "验证码不能为空");
			//请求转发之后当前servlet与regist.jsp页面看到的是同一块域，可以共享数据。
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//邮箱格式校验
		//lishuai@tedu.com
		String reg = "^\\w+@\\w+(\\.\\w+)+$";
		if(!email.matches(reg)){
			request.setAttribute("msg", "邮箱格式错误");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//密码一致性校验
		if(!password.equals(password2)){
			request.setAttribute("msg", "两次密码不一致");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//验证码校验
		String code = (String) request.getSession().getAttribute("code");
		if(!valistr.equalsIgnoreCase(code)){
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		//UserService
		User user = new User(0,username,MD5Utils.md5(password),nickname,email);
		try {
			userService.registUser(user);
		} catch (MsgException e) {
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("/regis.jsp").forward(request, response);
			return;
		}
		
		//
		//跳转回首页
		response.getWriter().write(
				"<h1 align='center'><font color='red'>" +
				"恭喜注册成功，3秒之后跳转回首页</font></h1>");
		response.setHeader("refresh", "3;url=http://www.easymall.com");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
