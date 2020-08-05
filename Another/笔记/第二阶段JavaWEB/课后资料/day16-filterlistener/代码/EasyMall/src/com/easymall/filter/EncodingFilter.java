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
//ȫվ���봦��
public class EncodingFilter implements Filter {
	String encode = "";
	boolean use_encode = false;
	public void init(FilterConfig filterConfig) throws ServletException {
		encode = filterConfig.getServletContext().getInitParameter("encode");
		//�Ƿ����ַ�������
		use_encode = Boolean.parseBoolean(filterConfig.getServletContext().getInitParameter("use_encode"));
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//1.response����
		response.setContentType("text/html;charset="+encode);
		//2.request���� post��
//		request.setCharacterEncoding(encode);
		//2.request���� get
		//�ڷ���request�����ʱ���ж��Ƿ�ʹ�����봦��ĺ��request����
		ServletRequest req = use_encode? new MyHttpServletRequest((HttpServletRequest) request,encode):request;
		
		//���� ������request����
		chain.doFilter(req, response);
		
	}

	public void destroy() {

	}

}
