package com.easymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easymall.utils.VerifyCode;
//生成验证码
public class ValidateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//控制缓存，防止浏览器使用验证码图片的缓存
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-control", "no-cache");
		//调用工具类产生一个验证码的图片
		VerifyCode vc = new VerifyCode();
		vc.drawImage(response.getOutputStream());
		//获取验证码的纯文本内容
		String code = vc.getCode();
		//将创建出来的验证码加入到session域中。
		request.getSession().setAttribute("code", code);
		System.out.println(code);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
