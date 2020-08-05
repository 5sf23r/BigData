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
 * ע�Ṧ��
 * @author Administrator
 *
 */
public class RegistServlet extends HttpServlet {
	private UserService userService = new UserService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���봦��
		//�����������Ӧ���봦��
		/*request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");*/
		
		//��ȡ�û����͵Ĳ�����Ϣ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String valistr = request.getParameter("valistr");
		//�ǿ�У��
		if(WebUtils.isNull(username)){
			//ע��ҳ����ʾ���û����Ʋ���Ϊ��
			request.setAttribute("msg", "�û����Ʋ���Ϊ��");
			//����ת��֮��ǰservlet��regist.jspҳ�濴������ͬһ���򣬿��Թ������ݡ�
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(password)){
			//ע��ҳ����ʾ���û����Ʋ���Ϊ��
			request.setAttribute("msg", "���벻��Ϊ��");
			//����ת��֮��ǰservlet��regist.jspҳ�濴������ͬһ���򣬿��Թ������ݡ�
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(password2)){
			//ע��ҳ����ʾ���û����Ʋ���Ϊ��
			request.setAttribute("msg", "ȷ�����벻��Ϊ��");
			//����ת��֮��ǰservlet��regist.jspҳ�濴������ͬһ���򣬿��Թ������ݡ�
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(nickname)){
			//ע��ҳ����ʾ���û����Ʋ���Ϊ��
			request.setAttribute("msg", "�ǳƲ���Ϊ��");
			//����ת��֮��ǰservlet��regist.jspҳ�濴������ͬһ���򣬿��Թ������ݡ�
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(email)){
			//ע��ҳ����ʾ���û����Ʋ���Ϊ��
			request.setAttribute("msg", "���䲻��Ϊ��");
			//����ת��֮��ǰservlet��regist.jspҳ�濴������ͬһ���򣬿��Թ������ݡ�
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WebUtils.isNull(valistr)){
			//ע��ҳ����ʾ���û����Ʋ���Ϊ��
			request.setAttribute("msg", "��֤�벻��Ϊ��");
			//����ת��֮��ǰservlet��regist.jspҳ�濴������ͬһ���򣬿��Թ������ݡ�
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//�����ʽУ��
		//lishuai@tedu.com
		String reg = "^\\w+@\\w+(\\.\\w+)+$";
		if(!email.matches(reg)){
			request.setAttribute("msg", "�����ʽ����");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//����һ����У��
		if(!password.equals(password2)){
			request.setAttribute("msg", "�������벻һ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//��֤��У��
		String code = (String) request.getSession().getAttribute("code");
		if(!valistr.equalsIgnoreCase(code)){
			request.setAttribute("msg", "��֤�����");
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
		//��ת����ҳ
		response.getWriter().write(
				"<h1 align='center'><font color='red'>" +
				"��ϲע��ɹ���3��֮����ת����ҳ</font></h1>");
		response.setHeader("refresh", "3;url=http://www.easymall.com");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
