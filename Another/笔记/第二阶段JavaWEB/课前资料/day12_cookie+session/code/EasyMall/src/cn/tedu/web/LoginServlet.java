package cn.tedu.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.utils.JDBCUtils;

/**
 * �����½��Servlet
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.������������
		// >>���������������
		request.setCharacterEncoding("utf-8");

		// 2.��ȡ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remname = request.getParameter("remname");

		// 3.ʵ�ּ�ס�û���
		if ("true".equals(remname)) {// ��ѡ�˼�ס�û���
			Cookie cookie = new Cookie("remname", URLEncoder.encode(username, "utf-8"));
			// ����Cookie���������ʱ��
			cookie.setMaxAge(3600 * 24 * 30);
			// ����Cookie��path
			cookie.setPath(request.getContextPath() + "/");
			// ��Cookie��ӵ�response��Ӧ��
			response.addCookie(cookie);
		} else {// ȡ����ס�û���(ɾ��Cookie)
			Cookie cookie = new Cookie("remname", "");
			cookie.setMaxAge(0);
			cookie.setPath(request.getContentType() + "/");
			response.addCookie(cookie);
		}

		// 4.��½�û�
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()){//�û���������ȷ
				//���û��������Session��, ��Ϊ�û���½�ı�ʶ
				request.getSession().setAttribute("user", username);
				
				// 5.��½�ɹ���ת����ҳ
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}else{
				request.setAttribute("msg", "�û��������벻��ȷ");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
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
