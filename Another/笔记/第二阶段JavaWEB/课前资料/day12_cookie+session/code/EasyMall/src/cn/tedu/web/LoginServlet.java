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
 * 处理登陆的Servlet
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.处理乱码问题
		// >>处理请求参数乱码
		request.setCharacterEncoding("utf-8");

		// 2.获取表单数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remname = request.getParameter("remname");

		// 3.实现记住用户名
		if ("true".equals(remname)) {// 勾选了记住用户名
			Cookie cookie = new Cookie("remname", URLEncoder.encode(username, "utf-8"));
			// 设置Cookie的最大生存时间
			cookie.setMaxAge(3600 * 24 * 30);
			// 设置Cookie的path
			cookie.setPath(request.getContextPath() + "/");
			// 将Cookie添加到response响应中
			response.addCookie(cookie);
		} else {// 取消记住用户名(删除Cookie)
			Cookie cookie = new Cookie("remname", "");
			cookie.setMaxAge(0);
			cookie.setPath(request.getContentType() + "/");
			response.addCookie(cookie);
		}

		// 4.登陆用户
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
			if(rs.next()){//用户名密码正确
				//将用户名保存进Session中, 作为用户登陆的标识
				request.getSession().setAttribute("user", username);
				
				// 5.登陆成功跳转回首页
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}else{
				request.setAttribute("msg", "用户名或密码不正确");
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
