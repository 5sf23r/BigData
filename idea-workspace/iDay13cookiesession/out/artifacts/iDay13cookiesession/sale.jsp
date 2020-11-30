<%--
  Created by IntelliJ IDEA.
  User: coe
  Date: 2020/11/29
  Time: 1:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" language="java" import="java.util.*" session="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="<%=request.getContextPath()%>/servlet/BuyServlet?prod=皮鞋">皮鞋</a>
  <a href="<%=request.getContextPath()%>/servlet/BuyServlet?prod=牙刷">牙刷</a>
  <a href="<%=request.getContextPath()%>/servlet/BuyServlet?prod=毛巾">毛巾</a>
  <a href="<%=request.getContextPath()%>/servlet/BuyServlet?prod=篮球">篮球</a>
  <a href="<%=request.getContextPath()%>/servlet/PayServlet">付款</a>
  </body>
</html>
