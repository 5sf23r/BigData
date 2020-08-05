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
import cn.tedu.utils.WebUtils;

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.�����������
			//>>��Ӧ��������
			response.setContentType("text/html;charset=utf-8");
			//>>�����������
			request.setCharacterEncoding("utf-8");
			
		//2.��ȡ�������(��ȡע������)
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");
			String valistr = request.getParameter("valistr");
			
		//3.����У�� 
			//>>�ǿ�У��
			if(WebUtils.isNull(username)){
				//У�鲻ͨ��, ����ʾ��Ϣ����request��
				request.setAttribute("msg", "�û�������Ϊ��");
				//ͨ��ת����ת��ע��ҳ, ��ȡ����ʾ��Ϣ������ʾ
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			if(WebUtils.isNull(password)){
				//У�鲻ͨ��, ����ʾ��Ϣ����request��
				request.setAttribute("msg", "���벻��Ϊ��");
				//ͨ��ת����ת��ע��ҳ, ��ȡ����ʾ��Ϣ������ʾ
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			if(WebUtils.isNull(password2)){
				//У�鲻ͨ��, ����ʾ��Ϣ����request��
				request.setAttribute("msg", "ȷ�����벻��Ϊ��");
				//ͨ��ת����ת��ע��ҳ, ��ȡ����ʾ��Ϣ������ʾ
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			if(WebUtils.isNull(nickname)){
				//У�鲻ͨ��, ����ʾ��Ϣ����request��
				request.setAttribute("msg", "�ǳƲ���Ϊ��");
				//ͨ��ת����ת��ע��ҳ, ��ȡ����ʾ��Ϣ������ʾ
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			if(WebUtils.isNull(email)){
				//У�鲻ͨ��, ����ʾ��Ϣ����request��
				request.setAttribute("msg", "���䲻��Ϊ��");
				//ͨ��ת����ת��ע��ҳ, ��ȡ����ʾ��Ϣ������ʾ
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			if(WebUtils.isNull(valistr)){
				//У�鲻ͨ��, ����ʾ��Ϣ����request��
				request.setAttribute("msg", "��֤�벻��Ϊ��");
				//ͨ��ת����ת��ע��ҳ, ��ȡ����ʾ��Ϣ������ʾ
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			
			//>>���������Ƿ�һ��
			if(!password.equals(password2)){
				//У�鲻ͨ��, ����ʾ��Ϣ����request��
				request.setAttribute("msg", "�������벻һ��");
				//ͨ��ת����ת��ע��ҳ, ��ȡ����ʾ��Ϣ������ʾ
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			
			//>>�����ʽ�Ƿ���ȷ
			String reg = "^\\w+@\\w+(\\.\\w+)+$";
			if(!email.matches(reg)){
				//У�鲻ͨ��, ����ʾ��Ϣ����request��
				request.setAttribute("msg", "�����ʽ����ȷ");
				//ͨ��ת����ת��ע��ҳ, ��ȡ����ʾ��Ϣ������ʾ
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			
			//>>��֤���Ƿ���ȷ
			//TODO
			
			
			//>>�û����Ƿ����
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
					request.setAttribute("msg", "�û����Ѵ���!");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);
					return;
				}
				
				//4.ע���û�(��ע�����ݱ�������ݿ�)
				sql = "insert into user values(null, ?,?,?,?)";
				ps =  conn.prepareStatement(sql);
				
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, nickname);
				ps.setString(4, email);
				
				ps.executeUpdate();
				
				//5.ע��ɹ�, 3��֮����ת����ҳ
				response.getWriter().write("<h1 style='color:red;text-align:center'>��ϲ��ע��ɹ�, 3��֮����ת����ҳ......</h1>");
				response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
				
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
