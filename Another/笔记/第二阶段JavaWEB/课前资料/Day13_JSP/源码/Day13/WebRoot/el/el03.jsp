<%@page import="cn.tedu.domain.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>EL获取常用开发对象 - EL的11个内置对象</title>
	</head>
	<body>
		<hr><h1>EL获取常用开发对象  - 代表四大作用域的内置对象</h1>
		<% 
			application.setAttribute("name", "朴乾");
			session.setAttribute("name", "鑫三胖");
			request.setAttribute("name", "曹二胖");
			pageContext.setAttribute("name", "李一瘦");
		 %>
		${name}
		${pageScope.name }
		${requestScope.name }
		${sessionScope.name }
		${applicationScope.name }
		<hr><h1>EL获取常用开发对象  - 代表请求参数的内置对象</h1>
		<%= request.getParameter("wg") %>
		${param.name}
		${param.wg}
		${param.mp}
		${param.like }
		${paramValues.like[0] }
		${paramValues.like[1] }
		${paramValues.like[2] }
		${paramValues.like[3] }
		<hr><h1>EL获取常用开发对象  - 获取代表web应用初始化参数的内置对象</h1>
		<%= application.getInitParameter("key01") %>
		${initParam.key02 }
		<hr><h1>EL获取常用开发对象  - 获取代表请求头内置对象</h1>
		<%=request.getHeader("Host") %>
		${header.host }
		${headerValues.host[0] }
		<hr><h1>EL获取常用开发对象  - 获取代表所有cookie组成的Map的内置对象</h1>
		<%Cookie[] cs = request.getCookies(); %>
		<%= cs[0].getName() %>
		${cookie.JSESSIONID.name }
		${cookie.JSESSIONID.value }
		<hr><h1>EL获取常用开发对象  - 获取代表当前页面PageContext对象</h1>
		<h2>el内置了pageContext,而pageContext中提供了获取其他八大隐式对象的getXxx方法，也就意味着，EL可以获取到所有的9大隐式对象</h2>
		<%=pageContext %>
		${pageContext}
		${pageContext.request }
	</body>
</html>
