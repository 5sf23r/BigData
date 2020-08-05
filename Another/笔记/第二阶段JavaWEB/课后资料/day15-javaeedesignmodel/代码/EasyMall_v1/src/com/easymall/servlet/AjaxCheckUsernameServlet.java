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
//ajax用户名查重校验
public class AjaxCheckUsernameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//乱码处理
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取ajax中的请求参数
		String username = request.getParameter("username");
		//连接数据库查重
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement("select * from user where username = ?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			//如果rs.next()为true则标签用户名已经存在
			if(rs.next()){
				//此处的响应数据为ajax的响应数据，会作为结果书写在前台触发ajax的选择器中
				response.getWriter().write("用户名已存在");
			}else{
				//此处的响应数据为ajax的响应数据，会作为结果书写在前台触发ajax的选择器中
				//返回一个用户名不存在提示到页面中
				response.getWriter().write("恭喜，用户名可以使用");
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
