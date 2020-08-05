package cn.tedu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FirstFilter初始化了...");
	}

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		System.out.println("first filter before...");
		chain.doFilter(request, response);
		System.out.println("first filter after...");
	}

	public void destroy() {
		System.out.println("FirstFilter销毁了...");
	}
}
