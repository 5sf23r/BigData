package com.easymall.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easymall.utils.JDBCUtils;
//ajax�û�������У��
public class AjaxCheckUsernameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���봦��
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//��ȡajax�е��������
		String username = request.getParameter("username");
		//�������ݿ����
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement("select * from user where username = ?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			//���rs.next()Ϊtrue���ǩ�û����Ѿ�����
			if(rs.next()){
				//�˴�����Ӧ����Ϊajax����Ӧ���ݣ�����Ϊ�����д��ǰ̨����ajax��ѡ������
				response.getWriter().write("�û����Ѵ���");
			}else{
				//�˴�����Ӧ����Ϊajax����Ӧ���ݣ�����Ϊ�����д��ǰ̨����ajax��ѡ������
				//����һ���û�����������ʾ��ҳ����
				response.getWriter().write("��ϲ���û�������ʹ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, ps, rs);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
