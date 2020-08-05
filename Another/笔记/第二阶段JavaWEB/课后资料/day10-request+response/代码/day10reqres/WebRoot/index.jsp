<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body>
  	<!-- 在首页中获取RequestDemo11中设置的域属性对应的值 -->
  	姓名：<%=request.getAttribute("username") %>
  	年龄：<%=request.getAttribute("age") %>
  	性别：<%=request.getAttribute("gender") %>
  	地址：<%=request.getAttribute("addr") %>
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  </body>
</html>
