package com.easymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easymall.utils.VerifyCode;
/**
 * ��ȡ��֤��
 * @author admin
 *
 */
public class ValistrServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ֹ�����ʹ�û���
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-control", "no-cache");
		VerifyCode vc =  new VerifyCode();
		//��ͼƬ����response������
		vc.drawImage(response.getOutputStream());
		
		//��֤�����ְ�
		String str = vc.getCode();
		System.out.println("��֤�룺"+str);
		
		//TODO:session
		HttpSession session = request.getSession();
		
		session.setAttribute("code", str);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
