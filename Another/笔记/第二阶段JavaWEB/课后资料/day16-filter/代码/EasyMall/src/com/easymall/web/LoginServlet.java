package com.easymall.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easymall.domain.User;
import com.easymall.exception.MsgException;
import com.easymall.service.UserService;
import com.easymall.utils.JDBCUtils;
//��¼����
public class LoginServlet extends HttpServlet {
	//����User��Ϣ��Service��
	private UserService userService = new UserService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.���봦��
		/*
		//2.��ȡ�û���Ϣrequest.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remname = request.getParameter("remname");
		//���remnameֵΪtrue��Ҫ���ס�û���
		if("true".equals(remname)){
			//ΪtrueҪ�󱣴��û���
			Cookie cookie = new Cookie("remname",URLEncoder.encode(username, "utf-8"));
			cookie.setMaxAge(60*60*24*30);
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
		}else{
			//�����Ϊtrue��Ӧ������cookie
			Cookie cookie = new Cookie("remname","");
			cookie.setMaxAge(0);
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
		}
		//3.�������ݿ⣬�ȶ��û���Ϣ
		/*Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement("select * from user where username =? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				//��¼����
				//���һ���򱣴��û���¼��Ϣ��
				//���û��ĵ�¼��Ϣ�洢��session����
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				//4.�ص���ҳ
				response.sendRedirect("http://www.easymall.com");
			}else{
				//�����һ������ҳ������ʾ�û��������벻��ȷ
				request.setAttribute("msg", "�û����������벻��ȷ");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, ps, rs);
		}*/
		//UserService�������javabean�ṩ������
		//UserService�ṩ�������ݵķ���
		//����½���ܵķ��ؽ����Ϊ�����û���½��Ϣʹ�á�������Ҫ����ֵ����
		User user =null;
		try {
			user = userService.loginUser(username,password);
			
		} catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//���û���Ϣ�������session��
		request.getSession().setAttribute("user", user);
		//�ص���ҳ
		response.sendRedirect(request.getContextPath()+"/");
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
