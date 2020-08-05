package com.easymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easymall.utils.VerifyCode;
/**
 * 获取验证码
 * @author admin
 *
 */
public class ValistrServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//禁止浏览器使用缓存
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-control", "no-cache");
		VerifyCode vc =  new VerifyCode();
		//将图片画入response缓冲区
		vc.drawImage(response.getOutputStream());
		
		//验证码文字版
		String str = vc.getCode();
		System.out.println("验证码："+str);
		
		//TODO:session
		HttpSession session = request.getSession();
		
		session.setAttribute("code", str);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
