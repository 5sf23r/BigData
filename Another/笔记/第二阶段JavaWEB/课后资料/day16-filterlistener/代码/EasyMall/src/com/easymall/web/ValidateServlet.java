package com.easymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easymall.utils.VerifyCode;
//������֤��
public class ValidateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���ƻ��棬��ֹ�����ʹ����֤��ͼƬ�Ļ���
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-control", "no-cache");
		//���ù��������һ����֤���ͼƬ
		VerifyCode vc = new VerifyCode();
		vc.drawImage(response.getOutputStream());
		//��ȡ��֤��Ĵ��ı�����
		String code = vc.getCode();
		//��������������֤����뵽session���С�
		request.getSession().setAttribute("code", code);
		System.out.println(code);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
