<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>展示个人资料</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	
	<body>
		姓名: <%= request.getAttribute("name") %> <br/>
		年龄: <%= request.getAttribute("age") %> <br/>
		昵称: <%= request.getAttribute("nickname") %> <br/>
		地址: <%= request.getAttribute("addr") %> <br/>
		<br>
	</body>
</html>
