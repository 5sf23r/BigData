package cn.tedu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("SecondFilter启动了");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("SecondFilter doFilter方法调用");
		//放行request
		chain.doFilter(request, response);
		System.out.println("SecondFilter doFilter方法调用结束");
	}

	public void destroy() {
		System.out.println("SecondeFilter销毁了");

	}

}
