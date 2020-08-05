<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
   	<a href="<%=request.getContextPath()%>/servlet/BuyServlet?prod=皮鞋">皮鞋</a>
   	<a href="<%=request.getContextPath()%>/servlet/BuyServlet?prod=毛巾">毛巾</a>
   	<a href="<%=request.getContextPath()%>/servlet/BuyServlet?prod=牙刷">牙刷</a>
   	<a href="<%=request.getContextPath()%>/servlet/BuyServlet?prod=馒头">馒头</a>
   	<a href="<%=request.getContextPath()%>/servlet/PayServlet">付款</a>
  </body>
</html>
