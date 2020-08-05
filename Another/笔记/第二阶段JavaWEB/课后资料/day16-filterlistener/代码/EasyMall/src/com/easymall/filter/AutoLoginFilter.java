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
//30�����Զ���¼
public class AutoLoginFilter implements Filter {

	public UserService userService = new UserService();
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//1.�ж��Ƿ��¼ ����session�����Ƿ����user���ж��û��Ƿ��¼
		HttpServletRequest req = (HttpServletRequest) request;
		//�ж�session�����Ƿ���ڣ����session�����ڣ���û�е�¼״̬��
		//�����session��û��user�����ԣ�
		//Ҳ������Ϊ��û�е�¼״̬
		if(req.getSession(false) == null
				||req.getSession().getAttribute("user")==null){
			//û�е�¼״̬
			Cookie[] cs = req.getCookies();
			Cookie autoLoginC = null;
			if(cs != null){
				for(Cookie c : cs){
					if("autologin".equals(c.getName())){
						autoLoginC = c;
					}
				}
				
			}
			//autologinC�п���δ�ҵ���������Ҫ���ж��Ƿ�Ϊ��
			if(autoLoginC != null){
				//��ȡcookie�е��û���������
				String str = autoLoginC.getValue();
				String[] values = str.split("#");
				String username = URLDecoder.decode(values[0], "utf-8");
				String password = values[1];
				//����Զ���¼
				//�������ݿ���Ϣ��ѯ�û��������������ƥ��
				User user = userService.loginUser(username,password );
				req.getSession().setAttribute("user", user);
			}
			
		}
		
		//���۵�¼�û����������Ƿ���ȷ��Ӧ�÷����������Ӧ��
		chain.doFilter(request, response);
		
	}

	public void destroy() {

	}

}
