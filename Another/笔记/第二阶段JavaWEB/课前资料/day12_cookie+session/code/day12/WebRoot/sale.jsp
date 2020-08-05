<%@ page language="java" import="java.util.*" pageEncoding="utf-8" session="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
</head>
<body>

	<a href="<%= request.getContextPath() %>/servlet/BuyServlet?prod=小米手机">小米手机</a> <br/> <br/>
	<a href="<%= request.getContextPath() %>/servlet/BuyServlet?prod=海尔洗衣机">海尔洗衣机</a> <br/> <br/>
	<a href="<%= request.getContextPath() %>/servlet/BuyServlet?prod=阿迪王皮鞋">阿迪王皮鞋</a> <br/> <br/>
	<a href="<%= request.getContextPath() %>/servlet/PayServlet">支付</a> <br/> <br/>
	
</body>
</html>
