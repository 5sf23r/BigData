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
		//1.��ȡ�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String valistr = request.getParameter("valistr");
		
		//��֤�� session
		//��session��ȡ��ValistrSevlet���ɵ���֤���ı�
		String code = (String) request.getSession().getAttribute("code");
		//��ȡ�û��������֤�� --- �Ϸ��Ѿ���ȡ���ˡ�
		//�ж��û���������ݺ�valistrServlet�е��ı��Ƿ���ͬ
		if(!code.equalsIgnoreCase(valistr)){
			//��֤����ȷ����Ҫ�κβ������������Ӧ����ҳ������ʾ������Ϣ
			request.setAttribute("msg", "��֤�벻��ȷ");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//2.�ǿ�У��
		if(WebUtils.isNull(username)){//���ù�������У��
			//request�������������
			//������������ϵ��������ɵ�ǰservlet���ݵ�regist.jsp��
			request.setAttribute("msg", "�û�������Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(password)){//���ù�������У��
			//request�������������
			//������������ϵ��������ɵ�ǰservlet���ݵ�regist.jsp��
			request.setAttribute("msg", "���벻��Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(password2)){//���ù�������У��
			//request�������������
			//������������ϵ��������ɵ�ǰservlet���ݵ�regist.jsp��
			request.setAttribute("msg", "ȷ�����벻��Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(nickname)){//���ù�������У��
			//request�������������
			//������������ϵ��������ɵ�ǰservlet���ݵ�regist.jsp��
			request.setAttribute("msg", "�ǳƲ���Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(email)){//���ù�������У��
			//request�������������
			//������������ϵ��������ɵ�ǰservlet���ݵ�regist.jsp��
			request.setAttribute("msg", "���䲻��Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(valistr)){//���ù�������У��
			//request�������������
			//������������ϵ��������ɵ�ǰservlet���ݵ�regist.jsp��
			request.setAttribute("msg", "��֤�벻��Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//3.����һ����У��
		if(password.trim() !="" && password2.trim() != "" 
				&& !password.trim().equals(password2.trim())){
			request.setAttribute("msg", "�������벻һ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//4.�����ʽУ��
		String reg = "\\w+@\\w+(\\.\\w+)+";
		if(!email.matches(reg)){
			request.setAttribute("msg", "�����ʽ����ȷ");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		//5.����Service����û�ע�Ṧ��
		//--��װ���ݵ�bean
		User user = new User(0,username,MD5Utils.md5(password),nickname,email);
		//--����Service�е���ط���
		UserService service = new UserService();
		try{
			service.registUser(user);
		}catch (MsgException e) {
			//--�ײ������Ҫ��ʾ�û� ��������Ϣչʾ��ԭ����ҳ��
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		//6.���ö�ʱˢ�·�����ҳ
		response.getWriter().write("<h1 align='center'><font color='red'>��ϲע��ɹ���3�����ת����ҳ��</font></h1>");
		response.setHeader("refresh", "3;url=http://www.easymall.com");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
