
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<title>el表达式</title>
</head>
<body>
	<h3>el表达式功能三：获取对象</h3>
	<h4>四个作用域</h4>
	${pageContext.request.contextPath}
	<h4>请求参数</h4>
	<%=request.getParameter("username") %>
	${param.username }
	<h4>请求头</h4>
	${header.host }
	<h4>web应用初始化配置信息的对象</h4>
	${initParam.key01 }
	<h4>cookie</h4>
	${cookie.JSESSIONID.name }
	${cookie.JSESSIONID.value }
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	
	
	
	
	
	
</body>
</html>