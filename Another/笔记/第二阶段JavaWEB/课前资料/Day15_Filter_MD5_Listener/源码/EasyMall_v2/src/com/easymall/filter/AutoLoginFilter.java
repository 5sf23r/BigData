package com.easymall.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.easymall.domain.User;
import com.easymall.exception.MsgException;
import com.easymall.service.UserService;

public class AutoLoginFilter implements Filter {

	private UserService userService = new UserService();
	
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//1.�û�δ��¼
		if(req.getSession(false) == null 
				|| req.getSession().getAttribute("user") == null){
			//2.�����Զ���¼cookie
			Cookie[] cs = req.getCookies();
			Cookie findc = null;
			if(cs!=null){
				for(Cookie c : cs){
					if("autologin".equals(c.getName())){
						findc = c;
					}
				}
			}
			if(findc != null){
				//3.�Զ���¼cookie�е��û���������ȷ
				String kv [] = findc.getValue().split("#");
				String username = URLDecoder.decode(kv[0], "utf-8");
				String password = kv[1];
				try {
					User user = userService.loginUser(username, password);
					//4.���������Զ���¼
					req.getSession().setAttribute("user", user);
				} catch (MsgException e) {
					//4.�û������벻��ȷ���򲻽����Զ���¼������Ҳ�����쳣
				}
			}
		}
		//5.�����Ƿ��Զ���¼��������Դ
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}
