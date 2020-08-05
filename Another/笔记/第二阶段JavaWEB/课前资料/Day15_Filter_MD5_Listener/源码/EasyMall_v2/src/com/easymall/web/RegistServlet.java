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

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String valistr = request.getParameter("valistr");
		
		//验证码 session
		//从session中取出ValistrSevlet生成的验证码文本
		String code = (String) request.getSession().getAttribute("code");
		//获取用户输入的验证码 --- 上方已经获取过了↑
		//判断用户输入的数据和valistrServlet中的文本是否相同
		if(!code.equalsIgnoreCase(valistr)){
			//验证码正确不需要任何操作，如果错误应该在页面中提示错误信息
			request.setAttribute("msg", "验证码不正确");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//2.非空校验
		if(WebUtils.isNull(username)){//利用工具类来校验
			//request可以用作域对象，
			//利用域对象身上的域将数据由当前servlet传递到regist.jsp中
			request.setAttribute("msg", "用户名不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(password)){//利用工具类来校验
			//request可以用作域对象，
			//利用域对象身上的域将数据由当前servlet传递到regist.jsp中
			request.setAttribute("msg", "密码不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(password2)){//利用工具类来校验
			//request可以用作域对象，
			//利用域对象身上的域将数据由当前servlet传递到regist.jsp中
			request.setAttribute("msg", "确认密码不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(nickname)){//利用工具类来校验
			//request可以用作域对象，
			//利用域对象身上的域将数据由当前servlet传递到regist.jsp中
			request.setAttribute("msg", "昵称不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(email)){//利用工具类来校验
			//request可以用作域对象，
			//利用域对象身上的域将数据由当前servlet传递到regist.jsp中
			request.setAttribute("msg", "邮箱不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(valistr)){//利用工具类来校验
			//request可以用作域对象，
			//利用域对象身上的域将数据由当前servlet传递到regist.jsp中
			request.setAttribute("msg", "验证码不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//3.密码一致性校验
		if(password.trim() !="" && password2.trim() != "" 
				&& !password.trim().equals(password2.trim())){
			request.setAttribute("msg", "两次密码不一致");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//4.邮箱格式校验
		String reg = "\\w+@\\w+(\\.\\w+)+";
		if(!email.matches(reg)){
			request.setAttribute("msg", "邮箱格式不正确");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		//5.调用Service完成用户注册功能
		//--封装数据到bean
		User user = new User(0,username,MD5Utils.md5(password),nickname,email);
		//--调用Service中的相关方法
		UserService service = new UserService();
		try{
			service.registUser(user);
		}catch (MsgException e) {
			//--底层出问题要提示用户 将错误信息展示回原来的页面
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		//6.利用定时刷新返回首页
		response.getWriter().write("<h1 align='center'><font color='red'>恭喜注册成功，3秒后跳转回首页！</font></h1>");
		response.setHeader("refresh", "3;url=http://www.easymall.com");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
