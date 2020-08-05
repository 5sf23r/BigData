package cn.tedu.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SCAttrTest01 extends HttpServlet {
	private ServletConfig sconfig = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.sconfig = config;
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sconfig.getServletContext().setAttribute("name", "zs");
		sconfig.getServletContext().setAttribute("name", "ls");
		sconfig.getServletContext().removeAttribute("name");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
