package com.easymall.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
//全站乱码处理
public class EncodingFilter implements Filter {
	String encode = "";
	boolean use_encode = false;
	public void init(FilterConfig filterConfig) throws ServletException {
		encode = filterConfig.getServletContext().getInitParameter("encode");
		//是否开启字符集处理
		use_encode = Boolean.parseBoolean(filterConfig.getServletContext().getInitParameter("use_encode"));
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//1.response对象
		response.setContentType("text/html;charset="+encode);
		//2.request对象 post、
//		request.setCharacterEncoding(encode);
		//2.request对象 get
		//在返回request对象的时候判断是否使用乱码处理的后的request对象
		ServletRequest req = use_encode? new MyHttpServletRequest((HttpServletRequest) request,encode):request;
		
		//放行 处理后的request对象
		chain.doFilter(req, response);
		
	}

	public void destroy() {

	}

}
