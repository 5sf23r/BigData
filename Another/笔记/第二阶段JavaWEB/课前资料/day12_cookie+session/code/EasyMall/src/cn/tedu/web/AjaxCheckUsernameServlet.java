package cn.tedu.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.tedu.utils.JDBCUtils;

public class AjaxCheckUsernameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.�����������
		//>>�����������
		request.setCharacterEncoding("utf-8");
		//>>��Ӧ��������
		response.setContentType("text/html;charset=utf-8");
		
		//2.��ȡ�������
		String username = request.getParameter("username");
		
		//>>����û����Ƿ����
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet  rs = null;
		//ʹ��c3p0���ӳػ�ȡ����
		try {
			//��ȡ����
			conn = JDBCUtils.getConn();
			String sql = "select * from user where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){//--true ��ʾ�û����Ѵ���
				response.getWriter().write("�û����Ѵ���!");
			}else{//false -- ������
				response.getWriter().write("��ϲ�û�������ʹ��!");
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
