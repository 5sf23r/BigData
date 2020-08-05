package com.easymall.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 全站乱码解决过滤器
 */
public class EcodingFilter implements Filter {
	private String encode = null;
	private boolean use_request_encoder = false;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		encode = filterConfig.getServletContext().getInitParameter("encode");
		use_request_encoder = Boolean.parseBoolean(filterConfig.getServletContext().getInitParameter("use_request_encoder"));
	}

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		//--全局请求乱码解决
		ServletRequest myRequest = use_request_encoder ? new MyHttpServletRequest(encode, (HttpServletRequest) request) : request;
		//--全局响应乱码解决
		response.setContentType("text/html;charset="+encode);
		//--放行资源
		chain.doFilter(myRequest, response);
	}

	public void destroy() {

	}

}
