<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="css/login.css"/>
		<title>EasyMall欢迎您登陆</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
		<script type="text/javascript">
			window.onload=function(){
				$("#username").val(decodeURI('${cookie.username.value}'))
			}
		</script>
	</head>
	<body>
		<h1>欢迎登陆EasyMall</h1>
		<form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
			<table>
				<tr>
					<td class="tdx" colspan=2 style="text-align:center;color:red">${msg }</td>
				</tr>
				<tr>
					<td class="tdx">用户名：</td>
					<td><input id="username" type="text" name="username" value=""/></td>
				</tr>
				<tr>
					<td class="tdx">密&nbsp;&nbsp; 码：</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="checkbox" name="remname" value="true" 
							<c:if test="${not empty cookie['username'] }" >
								checked='checked'
							</c:if>
						/>记住用户名
						<input type="checkbox" name="autologin" value="true"/>30天内自动登陆
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="登 陆"/>
					</td>
				</tr>
			</table>
		</form>		
	</body>
</html>
