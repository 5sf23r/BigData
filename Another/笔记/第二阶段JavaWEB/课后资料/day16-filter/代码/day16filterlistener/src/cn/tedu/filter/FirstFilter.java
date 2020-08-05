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
		System.out.println("FirstFilter Start.....");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("FirstFilter doFilter方法已经被访问");
		//放行当前请求或响应。
		chain.doFilter(request, response);
		System.out.println("FirstFilter doFilter方法已经被访问2");
	}

	public void destroy() {
		System.out.println("FirstFilter End.....");
	}

}
