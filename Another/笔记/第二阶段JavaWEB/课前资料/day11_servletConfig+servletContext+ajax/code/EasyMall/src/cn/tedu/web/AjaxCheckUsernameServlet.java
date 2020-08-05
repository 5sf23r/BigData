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
		//1.解决乱码问题
		//>>请求参数乱码
		request.setCharacterEncoding("utf-8");
		//>>响应正文乱码
		response.setContentType("text/html;charset=utf-8");
		
		//2.获取请求参数
		String username = request.getParameter("username");
		
		//>>检查用户名是否存在
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet  rs = null;
		//使用c3p0连接池获取连接
		try {
			//获取连接
			conn = JDBCUtils.getConn();
			String sql = "select * from user where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){//--true 表示用户名已存在
				response.getWriter().write("用户名已存在!");
			}else{//false -- 不存在
				response.getWriter().write("恭喜用户名可以使用!");
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
