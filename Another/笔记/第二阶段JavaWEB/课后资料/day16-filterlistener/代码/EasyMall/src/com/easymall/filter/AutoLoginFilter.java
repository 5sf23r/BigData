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
import com.easymall.service.UserService;
import com.easymall.utils.MD5Utils;
//30天内自动登录
public class AutoLoginFilter implements Filter {

	public UserService userService = new UserService();
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//1.判断是否登录 根据session域中是否包含user来判断用户是否登录
		HttpServletRequest req = (HttpServletRequest) request;
		//判断session对象是否存在，如果session不存在，则没有登录状态，
		//如果有session而没有user域属性，
		//也可以认为是没有登录状态
		if(req.getSession(false) == null
				||req.getSession().getAttribute("user")==null){
			//没有登录状态
			Cookie[] cs = req.getCookies();
			Cookie autoLoginC = null;
			if(cs != null){
				for(Cookie c : cs){
					if("autologin".equals(c.getName())){
						autoLoginC = c;
					}
				}
				
			}
			//autologinC有可能未找到，所以需要先判断是否为空
			if(autoLoginC != null){
				//获取cookie中的用户名和密码
				String str = autoLoginC.getValue();
				String[] values = str.split("#");
				String username = URLDecoder.decode(values[0], "utf-8");
				String password = values[1];
				//完成自动登录
				//根据数据库信息查询用户名和密码事如否匹配
				User user = userService.loginUser(username,password );
				req.getSession().setAttribute("user", user);
			}
			
		}
		
		//不论登录用户名和密码是否正确都应该放行请求和响应。
		chain.doFilter(request, response);
		
	}

	public void destroy() {

	}

}
